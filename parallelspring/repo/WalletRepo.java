package com.cg.parallelspring.repo;

import java.util.List;

import com.cg.parallelspring.beans.Customer;
//import com.cg.parallelspring.beans.Transact;
import com.cg.parallelspring.beans.Transact;

public interface WalletRepo {
	
	public boolean save(Customer customer);
	public Customer findOne(String mobileNo);
	public List<Transact> getAll(String mob);
	boolean allTransactions(Transact t);

}
