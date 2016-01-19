package com.saurabh.nab.customerServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.saurabh.nab.customerInfo.Customer;

@Component ("CustomerServices")
public class CustomerServices {

	private ArrayList<Customer> customers= new ArrayList<Customer>();
	public List<Customer> findAllCustomers() {
		
		return customers;
	}
	public void saveCustomer(Customer customer) {
		
		customers.add(customer);
	}
	public boolean isCustomerExist(Customer customer) {
		return customers.contains(customer);
	}

}
