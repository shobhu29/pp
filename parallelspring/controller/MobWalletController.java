package com.cg.parallelspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.parallelspring.beans.Customer;
import com.cg.parallelspring.beans.Transact;
import com.cg.parallelspring.exceptions.InsufficientBalanceException;
import com.cg.parallelspring.exceptions.InvalidInputException;
import com.cg.parallelspring.service.WalletService;




@Controller
public class MobWalletController {
	
	@Autowired
	WalletService walletser;
	
	
	@RequestMapping(value="menu")
	public String menu(){
		
		System.out.println("Redirecting to menu page...");
		return "menu";
	}
	
	@RequestMapping(value="addacc")
	public String addAccount(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to create account page......");
		return "createacc" ;
		
	}
	@RequestMapping(value="createaccsuccess",method=RequestMethod.POST)
	public String successone(@ModelAttribute("my") Customer cust){
		Customer c = null;
		System.out.println(cust);
		try {
			 c=walletser.createAccount(cust.getMobileNo(), cust.getName(), cust.getBalance());
			
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c);
		
		System.out.println("Account Created....");
		return "createaccsuccess";
	}
	
	@RequestMapping(value="showbal")
	public String showBalance(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to show balance page......");
		return "showbalance" ;
	
	}
	@RequestMapping(value="showbalancesuccess")
	public ModelAndView showBalanceSuccess(@ModelAttribute("my") Customer cust){
		Customer c=null;
		System.out.println("Redirecting to  balance display page......");
		try {
			 c=walletser.showBalance(cust.getMobileNo());
			System.out.println(c.getBalance());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("showbalancesuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="deposit")
	public String deposit(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to deposit money page......");
		return "deposit" ;
	}
	
	@RequestMapping(value="depositsuccess")
	public ModelAndView depositSuccess(@ModelAttribute("my") Customer cust){
		Customer c=null;
		System.out.println("Redirecting to  deposit success page......");
		try {
			 c=walletser.depositAmount(cust.getMobileNo(), cust.getBalance());
			System.out.println(c);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("depositsuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="withdraw")
	public String withdraw(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to withdraw(enter mobile no)  page......");
		return "withdraw" ;
	}
	@RequestMapping(value="withdraw2")
	public ModelAndView withdraw2(@ModelAttribute("my") Customer cust){
		System.out.println("Redirecting to withdraw(enter money) page......");
		Customer c=null;
		try {
			 c=walletser.showBalance(cust.getMobileNo());
			System.out.println(c);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("withdraw2", "data", c) ;
	}
	
	@RequestMapping(value="withdrawsuccess",method=RequestMethod.POST)
	public ModelAndView withdrawSuccess(@ModelAttribute("my") Customer cust,@RequestParam("mNo") String s ){
		Customer c=null;
		System.out.println("Redirecting to  withdraw success page......");
		System.out.println(cust.getMobileNo()+"     "+   cust.getBalance());
		System.out.println(s);
		
		try {
			 try {
				c=walletser.withdrawAmount(s, cust.getBalance());
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println(c);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("withdrawsuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="fundtransf")
	public String fundtransf(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to fundtransfer(enter mobile no)  page......");
		return "fundtransf" ;
	}
	@RequestMapping(value="fundtransf2")
	public ModelAndView fundtransf2(@ModelAttribute("my") Customer cust){
		System.out.println("Redirecting to fundtransf(enter money) page......");
		Customer c=null;
		try {
			 c=walletser.showBalance(cust.getMobileNo());
			System.out.println(c);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("fundtransf2", "data", c) ;
	}
	
	@RequestMapping(value="fundtransfsuccess",method=RequestMethod.POST)
	public ModelAndView fundtransfSuccess(@ModelAttribute("my") Customer cust,@RequestParam("amount") String s ){
		Customer c=null;
		System.out.println("Redirecting to  fundtransf success page......");
		System.out.println(cust.getMobileNo()+"     "+   cust.getBalance());
		System.out.println(s);
		
		try {
			 c=walletser.fundTransfer(s, cust.getMobileNo(), cust.getBalance());
			System.out.println(c);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("fundtransfsuccess", "data", c) ;
	
	}
	
	@RequestMapping(value="printtransc")
	public String printtransactionsl(@ModelAttribute("my") Customer cust){
		
		System.out.println("Redirecting to print transactions(enter mobile no)  page......");
		return "printtr" ;
	}
	
	@RequestMapping(value="printtransclist")
	public ModelAndView printtransactions(@ModelAttribute("my") Customer cust, Map<String, String> map,Map<String, Float> map1){
		System.out.println("Redirecting to transactions page......");
		Customer c=null;
		int i=1;
		try {
			c=walletser.checkAccount(cust.getMobileNo());
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> list1=new ArrayList<>();
		List<Transact> list=walletser.getAll(cust.getMobileNo());
		/*System.out.println(list.get(0));*/
		while(i<list.size()){
			list1.add(i);
			i++;
		}
		//map.put("iter", 1);
		map.put("name", c.getName());
		map.put("mob", c.getMobileNo());
		map1.put("bal", c.getBalance());
				
		return new ModelAndView("printtransc", "data", list) ;
	}
	
	
	
	
	
	
	
	
	
}
