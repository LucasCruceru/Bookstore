package ro.emanuel.info.lucas.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.info.lucas.bookstore.helper.DBHelper;
import ro.emanuel.info.lucas.bookstore.pojo.Order;

public class OrderDAO {
	
	public static void createOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String inserString = "INSERT INTO orders(date_order, total_price, customer_ID) VALUES (?,?,?);";

		PreparedStatement stmt = conn.prepareStatement(inserString);
		stmt.setString(1, o.getDateOrder());
		stmt.setDouble(2, o.getTotalPrice());
		stmt.setInt(3, o.getCustomerID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void createOrder(String dateOrder, double totalPrice, int customerID) throws SQLException {
		Order o = new Order(-1, dateOrder, totalPrice, customerID);
		OrderDAO.createOrder(o);
	}

	public static ArrayList<Order> getOrder() throws SQLException {
		ArrayList<Order> result = new ArrayList<Order>();

		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM orders";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("ID");
			String dateOrder = rs.getString("date_order");
			double totalPrice = rs.getDouble("total_price");
			int customerId = rs.getInt("customer_ID");

			Order o = new Order(id, dateOrder, totalPrice, customerId);
			result.add(o);
		}
		DBHelper.closeConnection(conn);
		return result;
	}
	
	public static Order getOrderById(int orderID) throws SQLException {
		Order result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM orders WHERE ID=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, orderID);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("ID");
			String dateOrder = rs.getString("date_order");
			double totalPrice = rs.getDouble("total_price");
			int customerId = rs.getInt("customer_ID");
			result = new Order(id, dateOrder, totalPrice, customerId);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE orders SET date_order = ?, total_price = ?, customer_ID = ? WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, o.getDateOrder());
		stmt.setDouble(2, o.getTotalPrice());
		stmt.setInt(3, o.getCustomerID());
		stmt.setInt(4, o.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void updateOrder(String dateOrder, double totalPrice, int customerID) throws SQLException {
		Order o = new Order(-1, dateOrder, totalPrice, customerID);
		OrderDAO.updateOrder(o);
	}

	public static void deleteOrder(Order o) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE FROM orders WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, o.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void deleteOrder(String dateOrder, double totalPrice, int customerID) throws SQLException {
		Order o = new Order(-1, dateOrder, totalPrice, customerID);
		OrderDAO.deleteOrder(o);
	}

}
