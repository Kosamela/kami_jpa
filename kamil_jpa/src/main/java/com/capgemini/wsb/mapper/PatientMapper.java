package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {

    private PatientMapper() {
    }

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        return patientEntity == null ? null : new PatientTO()
                .setId(patientEntity.getId())
                .setFirstName(patientEntity.getFirstName())
                .setLastName(patientEntity.getLastName())
                .setTelephoneNumber(patientEntity.getTelephoneNumber())
                .setEmail(patientEntity.getEmail())
                .setPatientNumber(patientEntity.getPatientNumber())
                .setDateOfBirth(patientEntity.getDateOfBirth())
                .setAddresses(patientEntity.getAddresses().stream().map(AddressMapper::mapToTO).collect(Collectors.toList()))
                .setVisits(patientEntity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()))
                .setGender(patientEntity.getGender());
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        return patientTO == null ? null : new PatientEntity()
                .setId(patientTO.getId())
                .setFirstName(patientTO.getFirstName())
                .setLastName(patientTO.getLastName())
                .setTelephoneNumber(patientTO.getTelephoneNumber())
                .setEmail(patientTO.getEmail())
                .setPatientNumber(patientTO.getPatientNumber())
                .setDateOfBirth(patientTO.getDateOfBirth())
                .setAddresses(patientTO.getAddresses().stream().map(AddressMapper::mapToEntity).collect(Collectors.toList()))
                .setVisits(patientTO.getVisits() != null ? patientTO.getVisits().stream().map(VisitMapper::mapToEntity).collect(Collectors.toList()) : List.of())
                .setGender(patientTO.getGender());
    }
}
