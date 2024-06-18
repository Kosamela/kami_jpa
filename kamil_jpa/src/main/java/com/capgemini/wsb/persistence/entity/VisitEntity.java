package com.capgemini.wsb.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	public LocalDateTime getTime() {
		return time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public VisitEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public VisitEntity setDescription(String description) {
		this.description = description;
		return this;
	}

	public VisitEntity setTime(LocalDateTime time) {
		this.time = time;
		return this;
	}

	public VisitEntity setDoctor(DoctorEntity doctor) {
		if (this.doctor != null) {
			this.doctor.getVisits().remove(this);
		}
		this.doctor = doctor;
		if (doctor != null) {
			doctor.getVisits().add(this);
		}
		return this;
	}

	public VisitEntity setPatient(PatientEntity patient) {
		this.patient = patient;
		return this;
	}

}

