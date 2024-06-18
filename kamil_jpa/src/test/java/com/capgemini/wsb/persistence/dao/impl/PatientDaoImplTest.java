package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PatientDaoImplTest {

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    void shouldFindByLastName() {
        // given
        String lastName = "Kowalska";

        // when
        List<PatientEntity> result = patientDao.findByLastName(lastName);

        // then
        assertEquals(1, result.size());
    }

    @Test
    void shouldFindPatientsWithMoreThanXVisits() {
        // given
        int baseNumberOfVisits = 5;

        // when
        List<PatientEntity> result = patientDao.findPatientsWithMoreThanXVisits(baseNumberOfVisits);

        // then
        assertEquals(0, result.size());
    }

    @Test
    void shouldFindMalePatients() {
        // when
        List<PatientEntity> result = patientDao.findMalePatients();

        // then
        assertEquals(1, result.size());
    }
}
