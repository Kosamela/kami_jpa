package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DoctorServiceImplTest {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testUpdateDoctorWithNewVisit() {
        DoctorEntity existingDoctor = doctorDao.find(1L);
        assertNotNull(existingDoctor);

        VisitEntity newVisit = new VisitEntity();
        newVisit.setDescription("test_dodanie");

        doctorService.updateDoctorWithNewVisit(DoctorMapper.mapToTO(existingDoctor), newVisit);

        DoctorEntity updatedDoctor = doctorDao.find(1L);
        assertNotNull(updatedDoctor);
        assertEquals(1, updatedDoctor.getVisits().size());
    }
    @Test
    public void testUpdateDoctorWithUpdatedVisit() {
        DoctorEntity existingDoctor = doctorDao.find(1L);
        assertNotNull(existingDoctor);

        VisitEntity visitToUpdate = existingDoctor.getVisits().stream()
                .filter(visit -> visit.getId().equals(1L))
                .findFirst()
                .orElse(null);
        assertNotNull(visitToUpdate);

        visitToUpdate.setDescription("test_edycja");

        doctorService.updateDoctorWithUpdatedVisit(DoctorMapper.mapToTO(existingDoctor), visitToUpdate);

        DoctorEntity updatedDoctor = doctorDao.find(1L);
        assertNotNull(updatedDoctor);
        assertEquals("test_edycja", updatedDoctor.getVisits().get(0).getDescription());
    }
}
