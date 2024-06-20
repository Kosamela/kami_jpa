package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DoctorEntity> findDoctorsByPatientAndDates(Long patientId, LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT d FROM DoctorEntity d JOIN d.visits v WHERE v.patient.id = :patientId AND v.date BETWEEN :startDate AND :endDate";
        return entityManager.createQuery(jpql, DoctorEntity.class)
                .setParameter("patientId", patientId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }


    @Override
    public DoctorEntity find(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }
    @Override
    public DoctorEntity update(DoctorEntity doctor) {
        entityManager.merge(doctor);
        return doctor;
    }
}
