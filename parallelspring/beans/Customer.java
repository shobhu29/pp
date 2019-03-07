package com.cg.parallelspring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity(name="cust")
@Table(name="customer_table1")
public class Customer {

	@Id
	@Column(name="mobileNo_cust")
	private String mobileNo;
	@Column(name="name_cust")
	private String name;
	@Column(name="balance_cust")
	private Float balance;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [mobileNo=" + mobileNo + ", name=" + name
				+ ", balance=" + balance + "]";
	}

	public Customer(String mobileNo, String name, float balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.balance = balance;
	}

	
	
	
	
	
	
	

}
