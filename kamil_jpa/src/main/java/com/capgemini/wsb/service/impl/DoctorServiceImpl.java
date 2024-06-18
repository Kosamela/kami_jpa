package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public void updateDoctor(DoctorTO doctorTO) {
        DoctorEntity doctor = doctorDao.find(doctorTO.getId());
        modelMapper.map(doctorTO, doctor);
        List<VisitEntity> visits = doctorTO.getVisits().stream()
                .map(visitTO -> {
                    VisitEntity visit = modelMapper.map(visitTO, VisitEntity.class);
                    visit.setDoctor(doctor);
                    return visit;
                })
                .collect(Collectors.toList());
        doctor.setVisits(visits);
        doctorDao.update(doctor);
    }

}
