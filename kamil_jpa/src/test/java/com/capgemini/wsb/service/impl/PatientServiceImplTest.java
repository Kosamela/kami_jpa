package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.Gender;
import com.capgemini.wsb.service.PatientService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    private static final String FIRST_NAME = "Jan";
    private static final String LAST_NAME = "Kowalski";
    private static final Gender GENDER = Gender.MALE;
    private static final String TELEPHONE_NUMBER = "555444333";
    private static final String EMAIL = "jan@kowalski.pl";
    private static final String PATIENT_NUMBER = "123";
    private static final List<AddressTO> ADDRESSES = List.of(new AddressTO());
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1999, 10, 10);

    private static final PatientTO PATIENT_T0 = new PatientTO()
            .setFirstName(FIRST_NAME)
            .setLastName(LAST_NAME)
            .setGender(Gender.MALE)
            .setTelephoneNumber(TELEPHONE_NUMBER)
            .setEmail(EMAIL)
            .setPatientNumber(PATIENT_NUMBER)
            .setAddresses(ADDRESSES)
            .setDateOfBirth(DATE_OF_BIRTH);

    @Test
    @Transactional
    @Order(1)
    void shouldCreatePatient() {
        // given

        patientService.createPatient(PATIENT_T0);
        // when
        PatientTO patientById = patientService.getPatientById(3L);

        //then
        assertEquals(FIRST_NAME, patientById.getFirstName());
        assertEquals(LAST_NAME, patientById.getLastName());
        assertEquals(EMAIL, patientById.getEmail());
        assertEquals(TELEPHONE_NUMBER, patientById.getTelephoneNumber());
        assertEquals(PATIENT_NUMBER, patientById.getPatientNumber());
        assertEquals(DATE_OF_BIRTH, patientById.getDateOfBirth());
        assertEquals(1, patientById.getAddresses().size());
        assertEquals(GENDER, patientById.getGender());
    }

    @Test
    @Transactional
    @Order(2)
    public void shouldDeletePatient() {
        // given

        // when
        patientService.deletePatientById(1L);
        patientService.deletePatientById(2L);

        //then
        assertTrue(patientDao.findAll().isEmpty());
        assertTrue(visitDao.findAll().isEmpty());
    }
}
