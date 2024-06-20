package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;

import java.time.LocalDate;
import java.util.List;

public interface DoctorDao extends Dao<DoctorEntity, Long> {
    DoctorEntity find(Long id);
    DoctorEntity update(DoctorEntity doctor);
    List<DoctorEntity> findDoctorsByPatientAndDates(Long patientId, LocalDate startDate, LocalDate endDate);
}