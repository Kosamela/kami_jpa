package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String telephoneNumber;

    private String email;

    @Column(nullable = false)
    private String patientNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "PATIENT_TO_ADDRESS",
            joinColumns = @JoinColumn(name = "PATIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VisitEntity> visits;

    public Long getId() {
        return id;
    }

    public PatientEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PatientEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PatientEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public PatientEntity setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PatientEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public PatientEntity setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public PatientEntity setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public PatientEntity setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
        return this;
    }

    public List<VisitEntity> getVisits() {
        return visits;
    }

    public PatientEntity setVisits(List<VisitEntity> visits) {
        this.visits = visits;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public PatientEntity setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

}
