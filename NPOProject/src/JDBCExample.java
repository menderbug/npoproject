import java.sql.*;
import java.util.Random;

public class JDBCExample {

	private static String server = "jdbc:sqlserver://npoproject.database.windows.net:1433;database=npoproject;user=azureuser@npoproject;password=6BILLIONturtles;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(server); Statement stmt = con.createStatement();) {

			String select = "SELECT * FROM CurrentDate";
			
			for (int i = 0; i < 1000; i++) {
				stmt.executeUpdate(randInsert());
			}
			
			// System.out.println(stmt.executeQuery(select));

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	private static int rand() {
		return (int) (Math.random() * 10);
	}

	private static String randInsert() {
		return String.format("INSERT INTO CurrentDate (year, month, day) VALUES (%d, %d, %d)", rand(), rand(), rand());
	}



	
}
