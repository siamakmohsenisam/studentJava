package personpackage;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String appartment;
	private String building;
	private String street;
	private String city;
	private String country;
	private String postalcode;
	
	public Address() {
		this("","","","","","");
	}
	public Address(String appartment, String building, String street, String city, String country, String postalcode) {
		this.appartment = appartment;
		this.building = building;
		this.street = street;
		this.city = city;
		this.country = country;
		this.postalcode = postalcode;
	}
	public String getAppartment() {
		return appartment;
	}
	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	@Override
	public String toString() {
		return "postalcode= " + postalcode;
	}
	public String toString2() {
		return "#" + appartment +" "+building + " " + street + " " + city
				+ " " + country + ", postalcode= " + postalcode;
	}
	
}
