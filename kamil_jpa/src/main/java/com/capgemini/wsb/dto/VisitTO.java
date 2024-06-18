package com.capgemini.wsb.dto;

import java.time.LocalDateTime;

public class VisitTO {

    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorTO doctor;
    private PatientTO patient;

    public Long getId() {
        return id;
    }

    public VisitTO setId(java.lang.Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VisitTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public VisitTO setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public VisitTO setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
        return this;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public VisitTO setPatient(PatientTO patient) {
        this.patient = patient;
        return this;
    }
}
