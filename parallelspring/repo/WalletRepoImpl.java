package com.cg.parallelspring.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cg.parallelspring.beans.Customer;
import com.cg.parallelspring.beans.Transact;


@Repository("walletrepo")
public class WalletRepoImpl implements WalletRepo {
	
	@PersistenceContext
	EntityManager manager;
	

	@Override
	public boolean save(Customer customer) {   //receives customer object from service layer and sends it to database
		
		if(customer!=null){
				//transaction begin
		manager.persist(customer);				// sends it to data base
		manager.flush();		//end transaction
		return true;							// successful transaction
		}
		
		return false;							//unsuccessful transaction
	
	}
	@Override
	public Customer findOne(String mobileNo) { 						//receives mobile no from service layer
		
		
		Customer custSearch=manager.find(Customer.class, mobileNo); //saerches in database
	
		return custSearch;											//returns it to database
		
	}


	@Override
	public boolean allTransactions(Transact t) {						//sends transactions to database		
		
		manager.persist(t);
		manager.flush();
		return true;
	}
	
	@Override
	public List<Transact> getAll(String mob){									//receives trasactions from database
		//List<Transact> list= new ArrayList<Transact>();				//creating list to store all transactions
		TypedQuery<Transact> sql=manager.createQuery("select p from Transact p where mobile=:imob",Transact.class); 
		sql.setParameter("imob", mob);
		List <Transact> list=sql.getResultList();
		/*for (Transact transact : list) {
			System.out.println(transact);
		}*/
		
		return list;
	}
	
	

}
