package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

    private static final String ADDRESS_LINE_1 = "line 1";
    private static final String ADDRESS_LINE_2 = "line 2";
    private static final String CITY = "city";
    private static final String POSTAL_CODE = "11-111";
    private static AddressEntity ADDRESS_ENTITY;

    @BeforeEach
    void reset() {
        ADDRESS_ENTITY = new AddressEntity()
                .setAddressLine1(ADDRESS_LINE_1)
                .setAddressLine2(ADDRESS_LINE_2)
                .setCity(CITY)
                .setPostalCode(POSTAL_CODE);
    }

    @Transactional
    @Test
    public void shouldFindAddressById() {
        // given
        // when
        AddressEntity addressEntity = addressDao.findOne(1L);
        // then
        assertThat(addressEntity).isNotNull();
        assertThat(addressEntity.getPostalCode()).isEqualTo(POSTAL_CODE);
    }

    @Test
    public void shouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity()
                .setAddressLine1(ADDRESS_LINE_1)
                .setAddressLine2(ADDRESS_LINE_2)
                .setCity(CITY)
                .setPostalCode(POSTAL_CODE);
        long entityCountBeforeSave = addressDao.count();

        // when
        final AddressEntity savedAddressEntity = addressDao.save(addressEntity);

        // then
        assertThat(savedAddressEntity).isNotNull();
        assertThat(savedAddressEntity.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entityCountBeforeSave + 1);
    }

    @Transactional
    @Test
    public void shouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity()
                .setAddressLine1(ADDRESS_LINE_1)
                .setAddressLine2(ADDRESS_LINE_2)
                .setCity(CITY)
                .setPostalCode(POSTAL_CODE);

        // when
        final AddressEntity savedAddressEntity = addressDao.save(addressEntity);
        assertThat(savedAddressEntity.getId()).isNotNull();
        final AddressEntity newSavedAddressEntity = addressDao.findOne(savedAddressEntity.getId());
        assertThat(newSavedAddressEntity).isNotNull();

        addressDao.delete(savedAddressEntity.getId());

        // then
        final AddressEntity removed = addressDao.findOne(savedAddressEntity.getId());
        assertThat(removed).isNull();
    }

}
