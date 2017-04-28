package ro.emanuel.info.lucas.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CRUDOrderDetails {
	
	public static void insert(int ID, int orderId, int productId) {
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
			int res = stmt.executeUpdate("INSERT INTO " + "bookstore_info.orderdetails(ID, OrderFK, ProductFK) VALUES "
					+ "('" + ID + "', '" + orderId + "', '" + productId + "')");

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
			int res = stmt.executeUpdate("DELETE FROM " + "bookstore_info.orderdetails WHERE ID= " + ID);

			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update(int ID, int orderId, int productId ) {

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
			int res = stmt.executeUpdate("UPDATE bookstore_info.orderdetails " + "SET OrderFK= '" + orderId + "', ProductFK= '" + productId +  "' WHERE ID = '" + ID + "';");
							
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
			ResultSet rs = stmt.executeQuery("Select * from bookstore_info.orderdetails;");

			// 4.process result
			while (rs.next()) {
				System.out.println(rs.getInt("ID") + " " + rs.getInt("OrderFK") + " " + rs.getInt("ProductFK") );
			}
			// 5.close connection
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
