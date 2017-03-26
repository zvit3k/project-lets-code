package com.pawlak.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pawlak.classes.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{
	
}
