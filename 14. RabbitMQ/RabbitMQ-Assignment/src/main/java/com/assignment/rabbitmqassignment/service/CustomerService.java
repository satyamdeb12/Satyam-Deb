package com.assignment.rabbitmqassignment.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rabbitmqassignment.config.MessagingConfig;
import com.assignment.rabbitmqassignment.entity.Customer;
import com.assignment.rabbitmqassignment.repository.CustomerRepository;

@RestController
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/customers")
	public String saveCustomer(@RequestBody Customer customer) {
		
		template.convertAndSend(MessagingConfig.MY_EXCHANGE, MessagingConfig.MY_ROUTING_KEY, customer);
		return "Customer Added Successfully";
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}
}
