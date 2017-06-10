package ro.emanuel.info.lucas.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CRUDProducts {

	public static void insert(int ID, String name, int price, int isInStore, String description) {
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
			int res = stmt.executeUpdate("INSERT INTO " + "bookstore_info.products(ProductID, Name, Price, isInStore, Description) VALUES "
					+ "('" + ID + "', '" + name + "', '" + price + "', '" + isInStore + "', '" + description + "')");

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
			int res = stmt.executeUpdate("DELETE FROM " + "bookstore_info.products WHERE ProductID= " + ID);

			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(int ID, String name, int price, int isInStore, String description) {

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
			int res = stmt.executeUpdate("UPDATE bookstore_info.products " + "SET Name= '" + name + "', Price= '" + price + "', isInStore= '" + isInStore +
					"', Description= '" + description + "'" + " WHERE ProductID = '" + ID + "';");
							
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
			ResultSet rs = stmt.executeQuery("Select * from bookstore_info.products;");

			// 4.process result
			while (rs.next()) {
				System.out.println(rs.getInt("ProductID") + " " + rs.getString("Name") + " " + rs.getInt("Price") + " "
						+ rs.getBoolean("isInStore") + " " + rs.getString("Description"));
			}
			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
