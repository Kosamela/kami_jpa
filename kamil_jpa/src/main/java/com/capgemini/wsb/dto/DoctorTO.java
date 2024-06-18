package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.util.List;

public class DoctorTO {

    private java.lang.Long id;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    private String doctorNumber;

    private Specialization specialization;

    private AddressTO address;

    private List<VisitTO> visits;

    public Long getId() {
        return id;
    }

    public DoctorTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public DoctorTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DoctorTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public DoctorTO setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DoctorTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public DoctorTO setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
        return this;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public DoctorTO setSpecialization(Specialization specialization) {
        this.specialization = specialization;
        return this;
    }
}
