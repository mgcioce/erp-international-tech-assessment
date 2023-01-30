package com.erpinternational.tech_assessment.ip_address_management.repository;

import com.erpinternational.tech_assessment.ip_address_management.model.AddressStatus;
import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPAddressRepository extends CrudRepository<IPAddress,Long> {


    @Modifying
    @Query("update IPAddress i set i.addressStatus = ?1 where i.ipAddress=?2 and i.subnetMask=?3 and i.ipVersion=?4")
    @Transactional
    public int setAddressStatusFor(AddressStatus addressStatus, String ipAddress, String subnetMask, String ipVersion);
}
