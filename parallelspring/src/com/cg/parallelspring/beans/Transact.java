package com.cg.parallelspring.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="transactions2")
public class Transact {

	@Id
	@Column(name="tr_i")
	Integer i;
	@Column(name="tr_s")
	String tr;
	@Column(name="trans_date")
	private String trDate;
	@Column(name="trans_mob")
	private String mobile;
	

	
	
	public Transact() {
		// TODO Auto-generated constructor stub
	}
	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}
	
	public String getTr() {
		return tr;
	}

	public void setTr(String tr) {
		this.tr = tr;
	}
	
	public String getTrDate() {
		return trDate.toString();
	}

	public void setTrDate() {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-YYYY HH:mm");									//dd/MM/yyyy
		Date rDate = new Date();
	    String strDate = sdfDate.format(rDate);
	    
		this.trDate = strDate;
	}
	
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Transact(Integer i, String tr, String trDate, String mobile) {
		super();
		this.i = i;
		this.tr = tr;
		this.trDate = trDate;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Transact [i=" + i + ", tr=" + tr + ", trDate=" + trDate
				+ ", mobile=" + mobile + "]";
	}




	
}
