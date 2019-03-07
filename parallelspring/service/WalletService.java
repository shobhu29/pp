package com.cg.parallelspring.service;

import java.util.List;

import com.cg.parallelspring.beans.Customer;
import com.cg.parallelspring.beans.Transact;
import com.cg.parallelspring.exceptions.InsufficientBalanceException;
import com.cg.parallelspring.exceptions.InvalidInputException;

public interface WalletService {
	
	public Customer createAccount(String custMobNo, String custName, float money) throws InvalidInputException;
	public Customer showBalance (String mobileno) throws InvalidInputException;
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, float amount) throws InvalidInputException;
	public Customer depositAmount (String mobileNo,float amount ) throws InvalidInputException;
	public Customer withdrawAmount(String mobileNo, float amount) throws InsufficientBalanceException, InvalidInputException;
	public Customer checkAccount(String mobileno) throws InvalidInputException;
	List<Transact> getAll(String mobno);
	


}
