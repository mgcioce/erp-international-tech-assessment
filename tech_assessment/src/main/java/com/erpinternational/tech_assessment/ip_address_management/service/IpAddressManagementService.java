package com.erpinternational.tech_assessment.ip_address_management.service;

import com.erpinternational.tech_assessment.ip_address_management.controller.model.AddressManagementDTO;
import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;

import java.util.Collection;
import java.util.List;

public interface IpAddressManagementService {

   public void addIpAddresses(AddressManagementDTO payload);

   public List<IPAddress> getAddresses();

   public IPAddress acquireAddress(AddressManagementDTO payload);

   public IPAddress releaseAddress(AddressManagementDTO payload);
}
