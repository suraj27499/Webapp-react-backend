package com.example.suraj;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
@Autowired
private CustomerRepository customerRepository;

public List<CustomerEntity> getAllCustomers(){
	return customerRepository.findAll();
}

public Optional<CustomerEntity> getCustomerById(Long id){
	return customerRepository.findById(id);
}

public CustomerEntity createCustomer(CustomerEntity customer){
	return customerRepository.save(customer);
}

public CustomerEntity getCustomer(CustomerEntity customer){
	return customerRepository.findByUserNameAndPassword(customer.getEmailId(), customer.getPassword());
}

public CustomerEntity updateCustomer(Long id, CustomerEntity customer){
	CustomerEntity cust = customerRepository.getById(id);
	
	if(customer.getFirstName() != null) {
		cust.setFirstName(customer.getFirstName());
	}
	
	if(customer.getLastName() != null) {
		cust.setLastName(customer.getLastName());
	}
	
	if(customer.getGender() != null) {
		cust.setGender(customer.getGender());
	}
	
	if(customer.getDob() != null) {
		cust.setDob(customer.getDob());
	}
	
	if(customer.getEmailId() != null) {
		cust.setEmailId(customer.getEmailId());
	}
	
	if(customer.getPassword() != null) {
		cust.setPassword(customer.getPassword());
	}
	return customerRepository.save(cust);
}

	public void deleteCustomer(Long id) {
	customerRepository.deleteById(id);
	}
}
