package ro.emanuel.info.lucas.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.info.lucas.bookstore.helper.DBHelper;
import ro.emanuel.info.lucas.bookstore.pojo.Customer;

public class CustomerDAO {

	public static void createCustomer(Customer c) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String inserString = "INSERT INTO customers(first_name, last_name, email, adress, city, district, country) VALUES (?,?,?,?,?,?,?);";

		PreparedStatement stmt = conn.prepareStatement(inserString);
		stmt.setString(1, c.getFirstName());
		stmt.setString(2, c.getLastName());
		stmt.setString(3, c.getEmail());
		stmt.setString(4, c.getAdress());
		stmt.setString(5, c.getCity());
		stmt.setString(6, c.getDistrict());
		stmt.setString(7, c.getCountry());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void createCustomer(String firstName, String lastName, String email, String adress, String city,
			String district, String country) throws SQLException {
		Customer c = new Customer(-1, firstName, lastName, email, adress, city, district, country);
		CustomerDAO.createCustomer(c);
	}

	public static ArrayList<Customer> getCustomer() throws SQLException {
		ArrayList<Customer> result = new ArrayList<Customer>();

		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM customers";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("ID");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String email = rs.getString("email");
			String adress = rs.getString("adress");
			String city = rs.getString("city");
			String district = rs.getString("district");
			String country = rs.getString("country");

			Customer c = new Customer(id, firstName, lastName, email, adress, city, district, country);
			result.add(c);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateCustomer(Customer c) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, adress = ?, city = ?, district = ?, country = ? WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, c.getFirstName());
		stmt.setString(2, c.getLastName());
		stmt.setString(3, c.getEmail());
		stmt.setString(4, c.getAdress());
		stmt.setString(5, c.getCity());
		stmt.setString(6, c.getDistrict());
		stmt.setString(7, c.getCountry());
		stmt.setInt(8, c.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void updateCustomer(String firstName, String lastName, String email, String adress, String city,
			String district, String country) throws SQLException {
		Customer c = new Customer(-1, firstName, lastName, email, adress, city, district, country);
		CustomerDAO.updateCustomer(c);
	}

	public static void deleteCustomer(Customer c) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE FROM customers WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, c.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void deleteCustomer(String firstName, String lastName, String email, String adress, String city,
			String district, String country) throws SQLException {
		Customer c = new Customer(-1, firstName, lastName, email, adress, city, district, country);
		CustomerDAO.deleteCustomer(c);
	}
	
}
