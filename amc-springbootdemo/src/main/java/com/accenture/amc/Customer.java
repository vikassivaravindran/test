package com.accenture.amc;

public class Customer {

	private Long customerId;
	
	private String customerName;
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	

	public Customer(Long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Customer() {
		super();
		
	}
	
	 

	
	
}
