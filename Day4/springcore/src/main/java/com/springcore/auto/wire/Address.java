package com.springcore.auto.wire;

public class Address {
	private String street;
	private String city;
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
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
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCity(String city) {
		this.city = city;
	}
}
