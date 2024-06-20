package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

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
	private String doctorNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinTable(
			name = "DOCTOR_TO_ADDRESS",
			joinColumns = @JoinColumn(name = "DOCTOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
	)
	private List<AddressEntity> address;

	@OneToMany(mappedBy = "doctor", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<VisitEntity> visits;

	public Long getId() {
		return id;
	}

	public DoctorEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public DoctorEntity setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public DoctorEntity setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public DoctorEntity setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public DoctorEntity setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public DoctorEntity setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
		return this;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public DoctorEntity setSpecialization(Specialization specialization) {
		this.specialization = specialization;
		return this;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public DoctorEntity setAddress(List<AddressEntity> address) {
		this.address = address;
		return this;
	}

	public List<VisitEntity> getVisits() {
		return visits;
	}

	public DoctorEntity setVisits(List<VisitEntity> visits) {
		this.visits = visits;
		return this;
	}
}
