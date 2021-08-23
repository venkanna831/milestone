package com.customerService.customer;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
@Autowired
private Repository service;
@GetMapping("/users/{id}")
public Optional<Customer> getcustomer(@PathVariable int id)
{
	return service.findById(id);
}
@GetMapping("/users")
public List<Customer> getallcustomer()
{
	return service.findAll();
}
@PostMapping("/users")
public int insertcustomer(@RequestBody Customer  customer)
{
	service.save(customer);
	return customer.getId();
}

}