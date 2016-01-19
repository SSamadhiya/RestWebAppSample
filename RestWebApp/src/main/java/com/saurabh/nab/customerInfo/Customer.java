package com.saurabh.nab.customerInfo;

public class Customer {
	
	private Integer id;
	private Name name;
	private Address address;
	private String sex;
	private String maritalStatus;
	private Integer creditRating;
	private Boolean isNABCustomer;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Integer getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}
	public Boolean getIsNABCustomer() {
		return isNABCustomer;
	}
	public void setIsNABCustomer(Boolean isNABCustomer) {
		this.isNABCustomer = isNABCustomer;
	}

	
}
