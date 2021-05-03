import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataGenerator {

	enum Gender {MALE, FEMALE};

	//TODO generate unique id num (not UUID)

	class Person {

		String fname, lname;
		Gender gender;
		String email;
		String phone_num;
		String address;		

	}

	private List<String> maleNames;
	private List<String> femaleNames;
	private List<String> lastNames;
	private List<String> streets;
	private List<String> suffixes = Arrays.asList("Road", "Lane", "Street", "Avenue", "Trail", "Place", "Way");

	private static String server = "jdbc:sqlserver://npoproject.database.windows.net:1433;database=npoproject;user=azureuser@npoproject;password=6BILLIONturtles;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	public DataGenerator() {
		try (Stream<String> mNames = Files.lines(Paths.get("male_names.txt"));
				Stream<String> fNames = Files.lines(Paths.get("female_names.txt"));
				Stream<String> lNames = Files.lines(Paths.get("last_names.txt"))
				Stream<String> sts = Files.lines(Paths.get("streets.txt"))) {

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
		pt.populate();

	}


	public void populate() {

		try (Connection con = DriverManager.getConnection(server); Statement stmt = con.createStatement()) {

			//Stream<>


			String select = "SELECT * FROM CurrentDate";
			
			for (int i = 0; i < 1000; i++) {
				stmt.executeUpdate(randInsert());
			}
			
			// System.out.println(stmt.executeQuery(select));

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	private List<Person> generateHumans(int num) {

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
			p.phone_num = rand(101, 999) + "-" + rand(0, 999) + "-" + rand(0, 9999);
			p.address = rand(1000, 99999) + " " + randVal(streets) + " " + randVal(suffixes); 
			
			output.add(p);

		}

		return output;

	}

	// link expenses to departments and donors (maybe directors)
	// track budget surplus/deficit

	private String randVal(List<String> list) {
		return list.get((int) (Math.random() * list.size()));
	}

	private int rand(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

	private String randInsert() {
		return String.format("INSERT INTO CurrentDate (year, month, day) VALUES (%d, %d, %d)", rand(), rand(), rand());
	}



	
}
