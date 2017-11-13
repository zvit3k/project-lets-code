package com.pawlak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByCityEquals(String city);
	List<Address> findBySchoolId(Long id);
}
