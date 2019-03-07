package com.cg.parallelspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.parallelspring.beans.Customer;
import com.cg.parallelspring.beans.Transact;
import com.cg.parallelspring.exceptions.InsufficientBalanceException;
import com.cg.parallelspring.exceptions.InvalidInputException;
import com.cg.parallelspring.repo.WalletRepo;

@Service("walletser")
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletRepo walletrepo;
	
	Transact trans=new Transact();
	
	public void saveTr(String s,String mob){
		trans.setTr(s);
		trans.setMobile(mob);
		int i=(int)( Math.random()*1000);
		trans.setI(i);
		trans.setTrDate();
		walletrepo.allTransactions(trans);
	}
	
	@Override
	public Customer createAccount(String mobileno, String name,
			float amount) throws InvalidInputException{
		
		Customer c=new Customer( mobileno,name, amount);
		if(walletrepo.save(c)){
			return c;
		}
		
		return null;
		
	}

	@Override
	public Customer showBalance(String mobileno) throws InvalidInputException {
		
		Customer cust=walletrepo.findOne(mobileno);
		
		if(cust==null)
			throw new InvalidInputException("Number not registered");
		else{
			String s="Balance Check "+cust.getBalance();
		saveTr(s,mobileno);
		/*trans.setTr(s);
		walletrepo.allTransactions(trans);*/
		return cust;
		}
	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			float amount) throws InvalidInputException {
		
		Customer cust1=walletrepo.findOne(sourceMobileNo);
		if(cust1==null)
			throw new InvalidInputException("Number not registered");
		
		float currentbal=cust1.getBalance();
		Customer cust2=walletrepo.findOne(targetMobileNo);
		if(cust2==null)
			throw new InvalidInputException("Receiver Number not registered in records");
		float currentbal2=cust2.getBalance();
		if(sourceMobileNo.equals(targetMobileNo))
			throw new InvalidInputException("Both Numbers are same");
		if(amount>20000)
			throw new InvalidInputException("Transfet limit is 20,000");
		
		if(currentbal<amount)
			throw new InvalidInputException("Your account balance is less than amount you are transferring");
		
		currentbal2= currentbal2 + amount;
		currentbal= currentbal - amount;
		
		cust1.setBalance(currentbal);
		walletrepo.save(cust1);	
		
		cust2.setBalance(currentbal2);		
		walletrepo.save(cust2);
		
		Customer cust3=walletrepo.findOne(sourceMobileNo);
		
		String s="Transferred amount "+amount+" to "+ targetMobileNo ;
		saveTr(s,sourceMobileNo);
		/*trans.setTr(s);
		walletrepo.allTransactions(trans);*/
		return cust3;
	}

	@Override
	public Customer depositAmount(String mobileNo, float amount) throws InvalidInputException {
		
		Customer cust=walletrepo.findOne(mobileNo);
		if(cust==null)
			throw new InvalidInputException("Number not registered");
		
		float currentbal=cust.getBalance();
		
		float newbal= currentbal + amount;
		cust.setBalance(newbal);
		walletrepo.save(cust);
		
		Customer cust1=walletrepo.findOne(mobileNo);
		
		String s="Amount Deposied "+amount;
		saveTr(s,mobileNo);
		/*trans.setTr(s);
		walletrepo.allTransactions(trans);*/
		
		return cust1;
	}

	@Override
	public Customer withdrawAmount(String mobileNo, float amount) throws InsufficientBalanceException, InvalidInputException {
		Customer cust=walletrepo.findOne(mobileNo);
		if(cust==null)
			throw new InvalidInputException("Number not registered");
		
		float currentbal=cust.getBalance();
		if(currentbal >amount){
			float newbal= currentbal-amount;
			
			cust.setBalance(newbal);
			walletrepo.save(cust);
		
			Customer cust1=walletrepo.findOne(mobileNo);
		
			String s="Amount Withdrawn "+amount ;
			saveTr(s,mobileNo);
			/*trans.setTr(s);
			walletrepo.allTransactions(trans);*/
			
		return cust1;
		}
		else
			throw new InsufficientBalanceException("Current balance is lesser than Withdraw Ammount ");
	}



	

	@Override
	public Customer checkAccount(String mobileno) throws InvalidInputException {
		Customer cust=walletrepo.findOne(mobileno);
		if(cust!=null)
			throw new InvalidInputException("Number already registered");
		else
		return null;
		
	}
	
	@Override
	public List<Transact> getAll(String mobno) {
		// TODO Auto-generated method stub
		return walletrepo.getAll(mobno);
	}
}
