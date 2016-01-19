package com.saurabh.nab.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.saurabh.nab.customerInfo.Customer;
import com.saurabh.nab.customerServices.CustomerServices;

@RestController
public class CustomerInfoController {
	
	@Autowired
	private CustomerServices customerService;
	
	 @RequestMapping(value = "/customer/", method = RequestMethod.GET)
	    public ResponseEntity<List<Customer>> listAllCustomers() {
	        List<Customer> customers = customerService.findAllCustomers();
	        if(customers.isEmpty()){
	            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/customer/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Customer " + customer.getName());
	 
	        if (customerService.isCustomerExist(customer)) {
	            System.out.println("A Customer with name " + customer.getName() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        customerService.saveCustomer(customer);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	 @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
		public List<Country> getCountries()
		{
			List<Country> listOfCountries = new ArrayList<Country>();
			listOfCountries=createCountryList();
			return listOfCountries;
		}
	 public List<Country> createCountryList()
		{
			Country indiaCountry=new Country(1, "India");
			Country chinaCountry=new Country(4, "China");
			Country nepalCountry=new Country(3, "Nepal");
			Country bhutanCountry=new Country(2, "Bhutan");

			List<Country> listOfCountries = new ArrayList<Country>();
			listOfCountries.add(indiaCountry);
			listOfCountries.add(chinaCountry);
			listOfCountries.add(nepalCountry);
			listOfCountries.add(bhutanCountry);
			return listOfCountries;
		}

}
