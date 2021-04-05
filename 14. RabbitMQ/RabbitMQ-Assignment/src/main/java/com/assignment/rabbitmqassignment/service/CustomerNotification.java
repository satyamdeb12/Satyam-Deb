package com.assignment.rabbitmqassignment.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.rabbitmqassignment.config.MessagingConfig;
import com.assignment.rabbitmqassignment.entity.Customer;
import com.assignment.rabbitmqassignment.repository.CustomerRepository;

@Component
public class CustomerNotification {

	@Autowired
	private CustomerRepository customerRepository;

	@RabbitListener(queues=MessagingConfig.MY_QUEUE)
	public void consumeMessageFromQueue(Customer customer){
		customerRepository.save(customer);
		
	}
}
