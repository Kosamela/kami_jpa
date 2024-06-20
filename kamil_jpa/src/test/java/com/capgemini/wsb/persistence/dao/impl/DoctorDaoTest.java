package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoctorDaoTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private DoctorDaoImpl doctorDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindDoctorsByPatientAndDates() {
        Long patientId = 1L;
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        DoctorEntity doctor1 = new DoctorEntity();
        DoctorEntity doctor2 = new DoctorEntity();
        List<DoctorEntity> expectedDoctors = new ArrayList<>();
        expectedDoctors.add(doctor1);
        expectedDoctors.add(doctor2);

        TypedQuery<DoctorEntity> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(DoctorEntity.class))).thenReturn(query);
        when(query.setParameter("patientId", patientId)).thenReturn(query);
        when(query.setParameter("startDate", startDate)).thenReturn(query);
        when(query.setParameter("endDate", endDate)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedDoctors);

        List<DoctorEntity> actualDoctors = doctorDao.findDoctorsByPatientAndDates(patientId, startDate, endDate);

        assertEquals(expectedDoctors, actualDoctors);
        verify(entityManager).createQuery(anyString(), eq(DoctorEntity.class));
        verify(query).setParameter("patientId", patientId);
        verify(query).setParameter("startDate", startDate);
        verify(query).setParameter("endDate", endDate);
        verify(query).getResultList();
    }

    @Test
    void testFind() {
        Long doctorId = 1L;
        DoctorEntity expectedDoctor = new DoctorEntity();
        when(entityManager.find(DoctorEntity.class, doctorId)).thenReturn(expectedDoctor);

        DoctorEntity actualDoctor = doctorDao.find(doctorId);

        assertEquals(expectedDoctor, actualDoctor);
        verify(entityManager).find(DoctorEntity.class, doctorId);
    }

    @Test
    void testUpdate() {
        DoctorEntity doctor = new DoctorEntity();
        when(entityManager.merge(doctor)).thenReturn(doctor);

        DoctorEntity updatedDoctor = doctorDao.update(doctor);

        assertEquals(doctor, updatedDoctor);
        verify(entityManager).merge(doctor);
    }
}
