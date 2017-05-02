package ro.emanuel.info.lucas.bookstore.pojo;

public class Order {
	private int ID;
	private String dateOrder;
	private double totalPrice;
	private int customerID;
	
	public Order() {
		super();
	}

	public Order(int iD, String dateOrder, double totalPrice, int customerID) {
		super();
		ID = iD;
		this.dateOrder = dateOrder;
		this.totalPrice = totalPrice;
		this.customerID = customerID;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	

}
