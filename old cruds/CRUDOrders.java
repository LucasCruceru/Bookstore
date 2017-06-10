package ro.emanuel.info.lucas.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CRUDOrders {
	
	public static void insert(int ID, String date, int totalPrice, int customerID) {
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
			int res = stmt.executeUpdate("INSERT INTO " + "bookstore_info.orders(OrderID, DateOrdered, TotalPrice ,CustomerID) VALUES "
					+ "('" + ID + "', '" + date + "', '" + totalPrice + "', '" + customerID +"')");

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
			int res = stmt.executeUpdate("DELETE FROM " + "bookstore_info.orders WHERE OrderID= " + ID);

			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(int ID, String date, int totalPrice, int customerID) {

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
			int res = stmt.executeUpdate("UPDATE bookstore_info.orders " + "SET DateOrdered= '" + date + "', TotalPrice= '" + totalPrice +
					"', CustomerID= '" + customerID  +"'" + " WHERE OrderID = '" + ID + "';");
							
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
			ResultSet rs = stmt.executeQuery("Select * from bookstore_info.orders;");

			// 4.process result
			while (rs.next()) {
				System.out.println(rs.getInt("OrderID") + " " + rs.getString("DateOrdered") + " " + rs.getInt("TotalPrice") + " "
						+ rs.getInt("CustomerID"));
			}
			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
