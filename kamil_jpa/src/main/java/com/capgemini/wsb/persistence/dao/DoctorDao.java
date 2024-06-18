package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.DoctorEntity;

public interface DoctorDao extends Dao<DoctorEntity, Long> {
    DoctorEntity find(Long id);
    DoctorEntity update(DoctorEntity doctor);
}