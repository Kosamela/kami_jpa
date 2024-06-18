package com.capgemini.wsb.persistence.dao;

public interface DoctorDao {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Doctor> findDoctorsByPatientAndDates(Long patientId, Date startDate, Date endDate) {
        string jpql = // query z jpql? potem return i update?
    }
}
