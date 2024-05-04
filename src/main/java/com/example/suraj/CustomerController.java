package com.example.suraj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/create")
	public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
		return customerService.createCustomer(customer);
	}
	
	@PostMapping("/getCustomer")
	public CustomerEntity getCustomer(@RequestBody CustomerEntity customer) {
		return customerService.getCustomer(customer);
	}
	
}
