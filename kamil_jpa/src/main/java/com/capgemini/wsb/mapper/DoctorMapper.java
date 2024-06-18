package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class DoctorMapper {

    private DoctorMapper() {
    }

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        return doctorEntity == null ? null : new DoctorTO().setId(doctorEntity.getId())
                .setFirstName(doctorEntity.getFirstName())
                .setLastName(doctorEntity.getLastName())
                .setTelephoneNumber(doctorEntity.getTelephoneNumber())
                .setEmail(doctorEntity.getEmail())
                .setDoctorNumber(doctorEntity.getDoctorNumber())
                .setSpecialization(doctorEntity.getSpecialization());
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        return doctorTO == null ? null : new DoctorEntity()
                .setId(doctorTO.getId())
                .setFirstName(doctorTO.getFirstName())
                .setLastName(doctorTO.getLastName())
                .setTelephoneNumber(doctorTO.getTelephoneNumber())
                .setEmail(doctorTO.getEmail())
                .setDoctorNumber(doctorTO.getDoctorNumber())
                .setSpecialization(doctorTO.getSpecialization());
    }
}
