package ro.emanuel.info.lucas.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CRUDCustomers {
	
	public static void insert(int ID, String fName, String lName, String email, String adress, String city, String district, String country) {
		// 1.create connection
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "lucas");

		String url = "jdbc:mysql://localhost:3306/bookstore_info";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			// 2.create statement
			Statement stmt = conn.createStatement();

			// insert product
			int res = stmt.executeUpdate("INSERT INTO " + "bookstore_info.customers(CustomerID, FirstName, LastName, Email, Adress, City, District, Country) VALUES "
					+ "('" + ID + "', '" + fName + "', '" + lName + "', '" + email + "', '" + adress +"', '" + city + "', '" + district  + "', '" + country + "')");

			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(int ID) {
		// 1.create connection
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "lucas");

		String url = "jdbc:mysql://localhost:3306/bookstore_info";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			// 2.create statement
			Statement stmt = conn.createStatement();

			// insert product
			int res = stmt.executeUpdate("DELETE FROM " + "bookstore_info.customers WHERE CustomerID= " + ID);

			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(int ID, String fName, String lName, String email, String adress, String city, String district, String country) {

		// 1.create connection
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "lucas");

		String url = "jdbc:mysql://localhost:3306/bookstore_info";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			// 2.create statement
			Statement stmt = conn.createStatement();

			// update product
			int res = stmt.executeUpdate("UPDATE bookstore_info.customers " + "SET FirstName= '" + fName + "', LastName= '" + lName + "', Email= '" + email +
					"', Adress= '" + adress + "', City= '" + city + "', District= '" + district + "', Country= '" + country +  "'" + " WHERE CustomerID = '" + ID + "';");
							
			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void selectAll() {
		// 1.create connection
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "lucas");

		String url = "jdbc:mysql://localhost:3306/bookstore_info";

		try {
			Connection conn = DriverManager.getConnection(url, prop);
			// 2.create statement
			Statement stmt = conn.createStatement();

			// 3.execute query
			ResultSet rs = stmt.executeQuery("Select * from bookstore_info.customers;");

			// 4.process result
			while (rs.next()) {
				System.out.println(rs.getInt("CustomerID") + " " + rs.getString("FirstName") + " " + rs.getString("LastName") + " "
						+ rs.getString("Email") + " " + rs.getString("Adress") + " " + rs.getString("City") + " " + rs.getString("District") + " " + rs.getString("Country") );
			}
			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
