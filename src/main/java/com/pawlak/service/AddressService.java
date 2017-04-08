package com.pawlak.service;

import java.util.List;

import com.pawlak.classes.Address;

public interface AddressService {
	void addAddress(Address s);
	void deleteAddress(Address s);
	List<Address> getAddressesEquals(String city);
}
