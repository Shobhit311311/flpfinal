package com.cg.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.daos.IReturnDao;
import com.cg.daos.TransactionDAO;
import com.cg.daos.UserDAO;
import com.cg.entities.Transaction;
import com.cg.entities.User1;
import com.cg.entities.Return;

@Service("returnService")
public class ReturnService implements IReturnService {

	@Autowired
	public IReturnDao returnDao;
	@Autowired
	TransactionDAO transactdao;
	@Autowired
	UserDAO userdao;
	
	@Override
	public List<Return> getAllReturnDetails() {
		return returnDao.findAll();
	}

	@Override
/*	public Return addrecordtoreturn(int temp) {

		Optional<Transaction> box = transactdao.findById(temp);
		if (box.isPresent()) {
			List<Return> returnlist = returnDao.findAll();
			returnlist = returnlist.stream().filter(ele -> {
				if (ele.getTransaction().getTransactionId() == temp) {
					return true;
				} else {
					return false;
				}
			}).collect(Collectors.toList());

			if (returnlist.size() > 0) {
				return null;
			} else {
				Return myreturn = new Return();
				myreturn.setTransaction(box.get());
				myreturn.setPickupDate(new Date());
				myreturn.setReturnStatus("success");
				returnDao.save(myreturn);
				return myreturn;

			}
		} else {
			return null;
		}

	}   */
	
	public Return addrecordtoreturn(int temp) {
        Return myreturn = new Return();

        Transaction myorder = transactdao.findById(temp).get();
        
        if(myorder.getStatus().equals("Delivered") && myorder!=null) {
        	myreturn.setTransaction(myorder);
    		myreturn.setPickupDate(new Date());
    		
    		myreturn.setReturnStatus("success");
    		myorder.setStatus("Returned");
    	    returnDao.saveAndFlush(myreturn);
    	    transactdao.saveAndFlush(myorder);
    	    return myreturn;
        }else {
        	return myreturn;
        }

	}
	public List<Integer> getTransaction(int userid){
//		List<Transaction> list=transactdao.findAll();
//		List<Integer> transactList=new ArrayList<Integer>();
// 		for(Transaction data:list) {
// 			if(data.getUser().getUserId()==userid) {
// 				transactList.add(data.getTransactionId());
// 			}
// 		}
//		return transactList;
		
		List<Transaction> transactionList=null;
		System.out.println(userid);
		User1 userObject=userdao.findById(userid).get();
		System.out.println(userObject);
		
		transactionList=transactdao.getAllTransactionByUser(userObject);
		
		if(transactionList.isEmpty() && transactionList==null) {
			System.out.println("Transactions Not Found");
			return null;
		}
		else {
			List<Integer> idsList=new ArrayList<Integer>();
			for(Transaction t:transactionList) {

//				System.out.println(t.getTransactionId());
				idsList.add(t.getTransactionId());
				
			}
			return idsList;
			
		}
		
	}

//	@Override
//	public String addTransaction(Transaction t) {
//	
//		try {
//			transactdao.save(t);
//		}catch(Exception e)
//		{
//			return e.getMessage();
//		}
//		return "Added";
//	}
//
//	@Override
//	public List<Transaction> getAllTransactions() {
//		
//		return transactdao.findAll();
//	}
//	

	
	/*  @Override public String checkstatus(int id) { // TODO Auto-generated
	 
	 
	 
	  Transaction myorder=transactdao.findById(id).get();
	  List<Return> prodreturn = returnDao.findAll();
	  for(Return ret:prodreturn) {
	  if(ret.getTransaction().getTransactionId()==id)
	  {
		 return null;
	  }
	  else
	  }
	  
	  return null;
	  }
*/	 

/*	@Override
	public List<Return> getreturngoods() {
		// TODO Auto-generated method stub
		return returnDao.findAll();
	}

	@Override
	public Return checkstatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}  */

}
