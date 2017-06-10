package ro.emanuel.info.lucas.bookstore.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
		public static Connection createConnection() {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "lucas");
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info_bookstore", prop);
				System.out.println("Connection to DB created");
				return conn;
			}catch(SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}
		return null;
		}
		
		public static void closeConnection(Connection con) {
			try{
				con.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}

}
