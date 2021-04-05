package com.assignment.rabbitmqassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rabbitmqassignment.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
