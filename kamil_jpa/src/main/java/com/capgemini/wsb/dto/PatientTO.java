package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PatientTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private List<AddressTO> addresses;
    private List<VisitTO> visits;
    private Gender gender;

    public Long getId() {
        return id;
    }

    public PatientTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PatientTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PatientTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public PatientTO setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PatientTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public PatientTO setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public PatientTO setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public List<AddressTO> getAddresses() {
        return addresses;
    }

    public PatientTO setAddresses(List<AddressTO> addresses) {
        this.addresses = addresses;
        return this;
    }

    public List<VisitTO> getVisits() {
        return visits;
    }

    public PatientTO setVisits(List<VisitTO> visits) {
        this.visits = visits;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public PatientTO setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "PatientTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addresses=" + addresses +
                ", visits=" + visits +
                ", gender=" + gender +
                '}';
    }
}
