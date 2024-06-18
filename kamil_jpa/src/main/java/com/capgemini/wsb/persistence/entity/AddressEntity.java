package com.capgemini.wsb.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	public Long getId() {
		return id;
	}

	public AddressEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCity() {
		return city;
	}

	public AddressEntity setCity(String city) {
		this.city = city;
		return this;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public AddressEntity setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public AddressEntity setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public AddressEntity setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

}
