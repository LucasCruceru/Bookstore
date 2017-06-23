package ro.emanuel.info.lucas.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.info.lucas.bookstore.helper.DBHelper;
import ro.emanuel.info.lucas.bookstore.pojo.OrderDetails;

public class OrderDetailsDAO {

	public static void createOrderDetails(OrderDetails od) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String inserString = "INSERT INTO order_details(order_ID, product_ID) VALUES (?,?);";

		PreparedStatement stmt = conn.prepareStatement(inserString);
		stmt.setInt(1, od.getOrderID());
		stmt.setInt(2, od.getProductID());
		

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void createOrderDetails(int orderID, int productID) throws SQLException {
		OrderDetails od = new OrderDetails(-1, orderID, productID);
		OrderDetailsDAO.createOrderDetails(od);
	}

	public static ArrayList<OrderDetails> getOrderDetails() throws SQLException {
		ArrayList<OrderDetails> result = new ArrayList<OrderDetails>();

		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM order_details";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("ID");
			int orderID = rs.getInt("order_ID");
			int productID = rs.getInt("product_ID");

			OrderDetails od = new OrderDetails(id, orderID, productID);
			result.add(od);
		}
		DBHelper.closeConnection(conn);
		return result;
	}
	
	public static OrderDetails getOrderDetailsById(int orderDetailsID) throws SQLException {
		OrderDetails result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM order_details WHERE ID=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, orderDetailsID);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int ID = rs.getInt("ID");
			int orderID = rs.getInt("order_ID");
			int productID = rs.getInt("product_ID");
	
			result = new OrderDetails(ID, orderID, productID);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateOrderDetails(OrderDetails od) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE order_details SET order_ID = ?, product_ID = ? WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setInt(1, od.getOrderID());
		stmt.setInt(2, od.getProductID());
		stmt.setInt(3, od.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void updateOrderDetails(int orderID, int productID) throws SQLException {
		OrderDetails od = new OrderDetails(-1, orderID, productID);
		OrderDetailsDAO.updateOrderDetails(od);
	}


	public static void deleteOrderDetails(OrderDetails od) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE FROM order_details WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, od.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void deleteOrderDetails(int orderID, int productID) throws SQLException {
		OrderDetails od = new OrderDetails(-1, orderID, productID);
		OrderDetailsDAO.deleteOrderDetails(od);
	}


}
