package com.accenture.amc;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){	
		
		return "<b><h1>WELCOME TO ACCENTURE MORTAGE CLOUD </h1></b>";
	}
	
	@RequestMapping(value="/customer/get/{customerId}", method = RequestMethod.GET)
	public Customer getByCustomerId(@PathVariable Long customerId) throws Exception{	
		
		
		if(customerId != null){
			if(logger.isInfoEnabled()){
				logger.info("Getting the customer with customer id "+customerId);
			}
			return customerService.getCustomer(customerId);
		}		
		return null;
	
	}

	@RequestMapping(value="/customer/save" , method=RequestMethod.POST)
	public Customer insertCustomer(@RequestBody Customer customer) throws Exception{
		
		if(customer !=null){
			if(logger.isInfoEnabled()){
				logger.info("Saving the customer with details "+customer.toString());
			}
			return customerService.saveCustomer(customer);
		}
	
		return customer;
	}
	
	@RequestMapping(value="/customer/update" , method=RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) throws Exception{
		
		if(customer !=null){
			if(logger.isInfoEnabled()){
				logger.info("Saving the customer with details "+customer.toString());
			}
			return customerService.updateCustomer(customer);
		}
	
		return customer;
	}
	

	@RequestMapping(value="/customer/delete/{customerId}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable Long customerId) throws Exception{	
		
		if(customerId != null){
			if(logger.isInfoEnabled()){
				logger.info("I am deleting a customer ID"+customerId);
			}
			 customerService.deleteCustomer(customerId);
		}		
		return "Customer with customer id "+customerId+" successfully deleted";
	
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exp){
		
		logger.error(exp.getMessage());
		return exp.getMessage();
	}


}
