package com.pawlak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pawlak.classes.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
}
