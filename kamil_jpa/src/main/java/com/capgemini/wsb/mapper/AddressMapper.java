package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;

public final class AddressMapper {

    private AddressMapper() {
    }

    public static AddressTO mapToTO(final AddressEntity addressEntity) {
        return addressEntity == null ? null : new AddressTO()
                .setId(addressEntity.getId())
                .setAddressLine1(addressEntity.getAddressLine1())
                .setAddressLine2(addressEntity.getAddressLine2())
                .setCity(addressEntity.getCity())
                .setPostalCode(addressEntity.getPostalCode());
    }

    public static AddressEntity mapToEntity(final AddressTO addressTO) {
        return addressTO == null ? null : new AddressEntity().setId(addressTO.getId())
                .setAddressLine1(addressTO.getAddressLine1())
                .setAddressLine2(addressTO.getAddressLine2())
                .setCity(addressTO.getCity())
                .setPostalCode(addressTO.getPostalCode());
    }
}
