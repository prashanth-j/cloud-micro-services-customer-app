package com.cts.cloudpoc;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public List<Customer> findByIdAndDateBetween(Integer id, Date from, Date to);

}
