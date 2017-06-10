package ro.emanuel.info.lucas.bookstore.pojo;

public class Product {
	
	private int ID;
	private String name;
	private double price;
	private int nrInStore;
	private String description;
	
	public Product() {
		super();
	}

	public Product(int ID, String name, double price, int nrInStore, String description) {
		super();
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.nrInStore = nrInStore;
		this.description = description;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNrInStore() {
		return nrInStore;
	}
	public void setNrInStore(int nrInStore) {
		this.nrInStore = nrInStore;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
