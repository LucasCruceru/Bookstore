package ro.emanuel.info.lucas.bookstore.pojo;

public class Product {
	
	private int ID;
	private String name;
	private double price;
	private int nrInStore;
	private String Description;
	
	public Product() {
		super();
	}

	public Product(int iD, String name, double price, int nrInStore, String description) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.nrInStore = nrInStore;
		Description = description;
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	

}
