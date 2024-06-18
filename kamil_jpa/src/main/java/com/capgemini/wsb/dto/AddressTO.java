package com.capgemini.wsb.dto;

import java.io.Serializable;

public class AddressTO implements Serializable
{
    private Long id;

    private String city;

    private String addressLine1;

    private String addressLine2;

    private String postalCode;

    public Long getId() {
        return id;
    }

    public AddressTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public AddressTO setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public AddressTO setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
