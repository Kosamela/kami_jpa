package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.TreatmentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	public Long getId() {
		return id;
	}

	public MedicalTreatmentEntity setId(Long id) {
		this.id = id;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MedicalTreatmentEntity setDescription(String description) {
		this.description = description;
		return this;
	}

	public TreatmentType getType() {
		return type;
	}

	public MedicalTreatmentEntity setType(TreatmentType type) {
		this.type = type;
		return this;
	}

}
