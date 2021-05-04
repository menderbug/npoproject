import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataGenerator {

	enum Gender {
		MALE, FEMALE
	};

	// TODO generate unique id num (not UUID)

	class NPO {
		int id;
		String name;
		String address;
		String email;
	}

	class Person {
		int id;
		String fname, lname;
		Gender gender;
		String email;
		String phone_num;
		String address;
		int wealth;
	}

	private List<String> maleNames;
	private List<String> femaleNames;
	private List<String> lastNames;
	private List<String> streets;
	private List<String> suffixes = Arrays.asList("Road", "Lane", "Street", "Avenue", "Trail", "Place", "Way");
	private List<String> domains = Arrays.asList("@gmail.com", "@yahoo.com", "@hotmail.com");
	private List<String> depts = Arrays.asList("Marketing", "Public Relations", "Human Resources", "Operations",
			"Finance", "Logistics", "Sales", "Information Technology", "Outreach");

	private static String server = "jdbc:sqlserver://npoproject.database.windows.net:1433;database=npoproject;user=azureuser@npoproject;password=6BILLIONturtles;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

	public DataGenerator() {
		try (Stream<String> mNames = Files.lines(Paths.get("src/male_names.txt"));
				Stream<String> fNames = Files.lines(Paths.get("src/female_names.txt"));
				Stream<String> lNames = Files.lines(Paths.get("src/last_names.txt"));
				Stream<String> sts = Files.lines(Paths.get("src/streets.txt"))) {

			maleNames = mNames.collect(Collectors.toList());
			femaleNames = fNames.collect(Collectors.toList());
			lastNames = lNames.collect(Collectors.toList());
			streets = sts.collect(Collectors.toList());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		DataGenerator pt = new DataGenerator();
		pt.drop();
		pt.populate();
	}

	public void drop() {
		List<String> tables = Arrays.asList("CurrentDate", "Department", "Donation", "Employee", "Expense", "Pledge",
				"Volunteer", "Donor", "Nonprofit");
		try (Connection con = DriverManager.getConnection(server); Statement stmt = con.createStatement()) {
			for (String s : tables)
				stmt.executeUpdate("DROP TABLE IF EXISTS " + s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void populate() {

		try (Connection con = DriverManager.getConnection(server); Statement stmt = con.createStatement()) {

			// setting current date
			stmt.executeUpdate(String.format("INSERT INTO CurrentDate (date) VALUES ('%s')",
					dateStr(LocalDate.of(2021, 5, 3))));

			// generating list of donors
			List<Person> donors = generatePeople(300);
			List<NPO> npos = generateNPOs();
			for (Person p : donors) {
				p.email = (p.fname + "." + p.lname + randVal(domains)).toLowerCase();
				stmt.executeUpdate(String.format(
						"INSERT INTO Donor (donor_id, donor_name, donor_gender, donor_address, donor_phone_number, donor_email) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
						p.id, p.fname + " " + p.lname, p.gender, p.phone_num, p.address, p.email));
				// donations: one-time, monthly, yearly
				for (int i = 0; i < rand(1, 5); i++)
					stmt.executeUpdate(String.format(
							"INSERT INTO Donation (donor_id, nonprofit_id, donation_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
							p.id, randVal(npos).id, dateStr(randDate()),
							Integer.toString((int) (p.wealth * (0.8 + 0.4 * Math.random()))), "one-time"));
				if (Math.random() < 0.2) {
					int amount = (int) (p.wealth * (0.8 + 0.4 * Math.random()));
					int npoid = randVal(npos).id;
					for (LocalDate ld = randDate(); ld.isAfter(LocalDate.of(2021, 5, 3)); ld = ld.plusMonths(1))
						stmt.executeUpdate(String.format(
								"INSERT INTO Pledge (donor_id, nonprofit_id, pledge_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
								p.id, npoid, ld, amount, "monthly"));
				}
				if (Math.random() < 0.1) {
					int amount = (int) (p.wealth * (0.8 + 0.4 * Math.random()));
					int npoid = randVal(npos).id;
					for (LocalDate ld = randDate(); ld.isAfter(LocalDate.of(2021, 5, 3)); ld = ld.plusYears(1))
						stmt.executeUpdate(String.format(
								"INSERT INTO Pledge (donor_id, nonprofit_id, pledge_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
								p.id, npoid, ld, amount, "yearly"));
				}
				// pledges: one-time, monthly, yearly
				for (int i = 0; i < rand(1, 5); i++)
					stmt.executeUpdate(String.format(
							"INSERT INTO Pledge (donor_id, nonprofit_id, pledge_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
							p.id, randVal(npos).id, dateStr(futureDate()),
							Integer.toString((int) (p.wealth * (0.8 + 0.4 * Math.random()))), "one-time"));
				if (Math.random() < 0.2)
					stmt.executeUpdate(String.format(
							"INSERT INTO Pledge (donor_id, nonprofit_id, pledge_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
							p.id, randVal(npos).id, dateStr(futureDate()),
							Integer.toString((int) (p.wealth * (0.8 + 0.4 * Math.random()))), "monthly"));
				if (Math.random() < 0.2)
					stmt.executeUpdate(String.format(
							"INSERT INTO Pledge (donor_id, nonprofit_id, pledge_date, amount, recurrence) VALUES ('%s', '%s', '%s', '%s', '%s')",
							p.id, randVal(npos).id, dateStr(futureDate()),
							Integer.toString((int) (p.wealth * (0.8 + 0.4 * Math.random()))), "yearly"));
			}

			// generating list of employees and volunteers
			for (NPO npo : npos) {

				// making departments
				for (String dept : depts)
					stmt.executeUpdate("INSERT INTO Department (dept_name, budget, director, nonprofit_id) VALUES ('%s', '%s', '%s', '%s')", dept, );

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private List<NPO> generateNPOs() {
		List<String> npos = Arrays.asList("Estonian Red Cross", "Feeding Lebanon", "Ethan Greeley Institute",
				"World Betterment", "Food for the Hungry", "San Francisco Zoo", "World Metro Opera",
				"American Liver Fund", "Provide for Korea");
		List<String> emails = Arrays.asList("info@erc.com", "info@feedinglebanon.com", "donate@egreeley.com",
				"info@betterment.com", "contactus@ffth.com", "contact@sfzoo.com", "info@wmopera.com",
				"contactus@alf.com", "donate@provide4korea.com");

		List<NPO> output = new ArrayList<NPO>();

		LinkedList<Integer> ids = new LinkedList<Integer>(randIDs(9));

		for (int i = 0; i < 9; i++) {
			NPO npo = new NPO();

			npo.id = ids.poll();
			npo.name = npos.get(i);
			npo.email = emails.get(i);
			npo.address = randAddress();
		}
		return output;
	}

	private List<Person> generatePeople(int num) {

		List<Person> output = new ArrayList<Person>();

		for (int i = 0; i < num; i++) {

			Person p = new Person();

			if (Math.random() > 0.5) {
				p.gender = Gender.MALE;
				p.fname = randVal(maleNames);
			} else {
				p.gender = Gender.FEMALE;
				p.fname = randVal(femaleNames);
			}

			p.lname = randVal(lastNames);
			p.phone_num = "1" + rand(101, 999) + "-" + rand(0, 999) + "-" + rand(0, 9999);
			p.address = randAddress();
			p.wealth = rand(100, 100000);

			output.add(p);

		}

		LinkedList<Integer> ids = new LinkedList<Integer>(randIDs(num));

		for (Person p : output)
			p.id = ids.poll();

		return output;

	}

	// link expenses to departments and donors (maybe directors)
	// track budget surplus/deficit

	private Set<Integer> randIDs(int num) {
		Set<Integer> output = new HashSet<Integer>();
		while (output.size() < num) {
			output.add(rand(10000, 99999));
		}
		return output;
	}

	private String randAddress() {
		return rand(1000, 99999) + " " + randVal(streets) + " " + randVal(suffixes);
	}

	private LocalDate randDate() {
		return LocalDate.of(2000, 1, 1)
				.plusDays(LocalDate.of(2000, 1, 1).until(LocalDate.of(2021, 5, 3), ChronoUnit.DAYS));
	}

	private LocalDate futureDate() {
		return LocalDate.of(2021, 5, 3)
				.plusDays(LocalDate.of(2021, 5, 3).until(LocalDate.of(2060, 1, 1), ChronoUnit.DAYS));
	}

	private String dateStr(LocalDate ld) {
		return ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	private <T> T randVal(List<T> list) {
		return list.get((int) (Math.random() * list.size()));
	}

	private int rand(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

}
