package com.pawlak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawlak.classes.Address;
import com.pawlak.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	private AddressRepository addressRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public void addAddress(Address s) {
		addressRepository.save(s);
		
	}

	@Override
	public void deleteAddress(Address s) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
