package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	public Optional<Customer> getCustomerByid(Integer id);
	
	/*public Optional <Customer>  removeCustomerByid(Integer id);*/
	@Transactional
	public Optional<Customer> deleteCustomerByid(Integer id);
	@Transactional
	public Optional<Customer> deleteCustomerByname(String name);
	

	

}
