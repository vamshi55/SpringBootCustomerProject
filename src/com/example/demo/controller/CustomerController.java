package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.css.CSSUnknownRule;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@GetMapping("/")
	public List<Customer> insert(){
		List<Customer> custlist= new ArrayList<>();
		custlist.add(new Customer(1, "A", 9898));
		custlist.add(new Customer(2, "B", 8989));
		customerRepository.saveAll(custlist);
		return customerRepository.findAll();
		
	}

	@PostMapping("/add")
	public List<Customer> read(@RequestBody List<Customer> custlist){
		
		customerRepository.saveAll(custlist);
		
		//List<Customer> custlist=cust;
		return customerRepository.findAll();
		
	}
	@GetMapping("/all")
	public List<Customer> allrecords(){
		
		return customerRepository.findAll();
		
		
	}
	@GetMapping("/getByid/{id}")
	public Optional<Customer> getCustomerById(@PathVariable Integer id){
		return customerRepository.getCustomerByid(id);
	}
	@DeleteMapping("/delete/{id}")
	public Optional<Customer>  delete(@PathVariable int id){
	
	return customerRepository.deleteCustomerByid(id);
			
	}
	@DeleteMapping("/deleteByname/{name}")
	public Optional<Customer>  delete(@PathVariable String name){
		return customerRepository.deleteCustomerByname(name);
	}
}
