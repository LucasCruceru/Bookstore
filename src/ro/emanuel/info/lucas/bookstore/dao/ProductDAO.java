package ro.emanuel.info.lucas.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.info.lucas.bookstore.helper.DBHelper;
import ro.emanuel.info.lucas.bookstore.pojo.Product;

public class ProductDAO {
	
	public static void createProduct(Product p) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String inserString = "INSERT INTO products(name, price, nr_in_store, description) VALUES (?,?,?,?);";

		PreparedStatement stmt = conn.prepareStatement(inserString);
		stmt.setString(1, p.getName());
		stmt.setDouble(2, p.getPrice());
		stmt.setInt(3, p.getNrInStore());
		stmt.setString(4, p.getDescription());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}

	public static void createProduct(String name, double price, int nrInStore, String description) throws SQLException {
		Product p = new Product(-1, name, price, nrInStore, description);
		ProductDAO.createProduct(p);
	}

	public static ArrayList<Product> getProduct() throws SQLException {
		ArrayList<Product> result = new ArrayList<Product>();

		Connection conn = DBHelper.createConnection();

		String selectString = "SELECT * FROM products 	";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(selectString);

		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			int nrInStore = rs.getInt("nr_in_store");
			String description = rs.getString("description");

			Product p = new Product(id, name, price, nrInStore, description);
			result.add(p);
		}
		DBHelper.closeConnection(conn);
		return result;
	}
	
	public static Product getProductById(int productID) throws SQLException {
		Product result = null;
		Connection conn = DBHelper.createConnection();

		String selectString = "select * from customers where id=?";
		PreparedStatement stmt = conn.prepareStatement(selectString);
		stmt.setInt(1, productID);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			int ID = rs.getInt("ID");
			String name = rs.getString("name");
			double price = rs.getDouble("price");
			int nrInStore = rs.getInt("nrInStore");
			String description = rs.getString("description");

			result = new Product(ID, name, price, nrInStore, description);
		}
		DBHelper.closeConnection(conn);
		return result;
	}

	public static void updateProduct(Product p) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String updateString = "UPDATE products SET name = ?, price = ?, nr_in_store = ?, description = ? WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(updateString);
		stmt.setString(1, p.getName());
		stmt.setDouble(2, p.getPrice());
		stmt.setInt(3, p.getNrInStore());
		stmt.setString(4, p.getDescription());
		stmt.setInt(5, p.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void updateProduct(String name, double price, int nrInStore, String description) throws SQLException {
		Product p = new Product(-1, name, price, nrInStore, description);
		ProductDAO.updateProduct(p);
	}
	

	public static void deleteProduct(Product p) throws SQLException {
		Connection conn = DBHelper.createConnection();

		String deleteString = "DELETE FROM products WHERE ID = ?";

		PreparedStatement stmt = conn.prepareStatement(deleteString);
		stmt.setInt(1, p.getID());

		stmt.executeUpdate();

		DBHelper.closeConnection(conn);
	}
	
	public static void deleteProduct(String name, double price, int nrInStore, String description) throws SQLException {
		Product p = new Product(-1, name, price, nrInStore, description);
		ProductDAO.deleteProduct(p);
	}

}
