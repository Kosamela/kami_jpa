package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {

    private VisitMapper() {
    }

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        return visitEntity == null ? null : new VisitTO()
                .setId(visitEntity.getId())
                .setDescription(visitEntity.getDescription())
                .setTime(visitEntity.getTime())
                .setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()))
                .setPatient(PatientMapper.mapToTO(visitEntity.getPatient()));
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        return visitTO == null ? null : new VisitEntity()
                .setId(visitTO.getId())
                .setDescription(visitTO.getDescription())
                .setTime(visitTO.getTime())
                .setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()))
                .setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));
    }
}