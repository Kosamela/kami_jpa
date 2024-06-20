package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorServiceImpl {

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    public void updateDoctorWithNewVisit(DoctorTO doctorTO, VisitEntity newVisit) {
        DoctorEntity doctor = doctorDao.find(doctorTO.getId());
        List<VisitEntity> visits = doctor.getVisits();
        visits.add(newVisit);
        newVisit.setDoctor(doctor);
        doctorDao.update(doctor);
    }

    @Transactional
    public void updateDoctorWithUpdatedVisit(DoctorTO doctorTO, VisitEntity updatedVisit) {
        DoctorEntity doctor = doctorDao.find(doctorTO.getId());
        List<VisitEntity> visits = doctor.getVisits();
        visits.stream()
                .filter(visit -> visit.getId().equals(updatedVisit.getId()))
                .findFirst()
                .ifPresent(existingVisit -> {
                    existingVisit.setDescription(updatedVisit.getDescription());
                });
        doctorDao.update(doctor);
    }
}
