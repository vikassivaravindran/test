package com.accenture.amc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerService.class);
	private Map<Long,Customer> customers=null;
	
	public CustomerService() {
		this.customers=new ConcurrentHashMap<Long,Customer>();
	}
	
	
	public Customer saveCustomer(Customer customer) throws Exception{
		
		if(!customers.containsKey(customer.getCustomerId())){
			customers.put(customer.getCustomerId(), customer);
		}else{
			throw new Exception("Customer with same details already exists");
		}
		
		return customer;
		
	}
	
	public Customer getCustomer(Long customerId) throws Exception{
		
		Customer customer=null;
		if(customers.containsKey(customerId)){
			customer=customers.get(customerId);
		}else{
			throw new Exception("Customer with customer id "+customerId+" not found");
		}
		return customer;
		
	}

	
	public Customer updateCustomer(Customer customer) throws Exception{
		
		if( getCustomer(customer.getCustomerId()) != null){
			customers.put(customer.getCustomerId(), customer);
		}
		return customer;
		
	}

	public void deleteCustomer(Long customerId){	
		
		customers.remove(customerId);
	
		
	}

	

}
