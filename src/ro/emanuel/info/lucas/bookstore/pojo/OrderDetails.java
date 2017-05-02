package ro.emanuel.info.lucas.bookstore.pojo;

public class OrderDetails {
	
	private int ID;
	private int orderID;
	private int productID;
	
	public OrderDetails() {
		super();
	}

	public OrderDetails(int iD, int orderID, int productID) {
		super();
		ID = iD;
		this.orderID = orderID;
		this.productID = productID;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	

}
