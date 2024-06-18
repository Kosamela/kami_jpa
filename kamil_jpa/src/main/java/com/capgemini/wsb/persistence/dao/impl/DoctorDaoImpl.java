package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;


public class DoctorDaoImpl extends AbstractDao<DoctorEntity, Long> implements DoctorDao {
    @PersistenceContext
    private EntityManager entityManager;


    public List<DoctorEntity> findDoctorsByPatientAndDates(Long patientId, Date startDate, Date endDate) {
        String jpql = "SELECT d FROM Doctor d JOIN d.visits v WHERE v.patient.id = :patientId AND v.date BETWEEN :startDate AND :endDate";
        return entityManager.createQuery(jpql, DoctorEntity.class)
                .setParameter("patientId", patientId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
