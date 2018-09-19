package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Customer;

interface CustomerRepository extends CrudRepository<Customer, Long> {}