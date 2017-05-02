package ro.emanuel.info.lucas.bookstore.pojo;

public class Customer {
	
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String adress;
	private String city;
	private String district;
	private String country;
	
	
	
	public Customer() {
		super();
	}
	
	public Customer(int iD, String firstName, String lastName, String email, String adress, String city,
			String district, String country) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adress = adress;
		this.city = city;
		this.district = district;
		this.country = country;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
