package com.erpinternational.tech_assessment.ip_address_management.service;

import com.erpinternational.tech_assessment.ip_address_management.controller.model.AddressManagementDTO;
import com.erpinternational.tech_assessment.ip_address_management.model.AddressStatus;
import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;
import com.erpinternational.tech_assessment.ip_address_management.repository.IPAddressRepository;
import inet.ipaddr.IPAddressString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Ipv4AddressManagementService implements IpAddressManagementService{

    @Autowired
    private IPAddressRepository ipAddressRepository;
    @Override
    public void addIpAddresses(AddressManagementDTO payload) {
        List<IPAddress> addresses = getAddressRecords(payload);
        addresses.forEach(ipAddress -> ipAddressRepository.save(ipAddress));
    }

    protected List<IPAddress> getAddressRecords(AddressManagementDTO payload){
        List<IPAddress> addresses = new ArrayList<>();
        inet.ipaddr.IPAddress cidrBlock = new IPAddressString(payload.getCidrBlock()).getAddress();
        cidrBlock.stream().forEach(ipAddress -> addresses.add(new IPAddress(ipAddress.getIPVersion().name(),
                                                                            ipAddress.getLower().withoutPrefixLength().toString(),
                                                                            ipAddress.getNetworkMask().toSubnetString(),
                                                                            AddressStatus.AVAILABLE)));
        return addresses;
    }

    @Override
    public List<IPAddress> getAddresses(){
        List<IPAddress> addresses = new ArrayList<>();
        ipAddressRepository.findAll().forEach(ipAddress -> addresses.add(ipAddress));
        return addresses;
    }

    @Override
    public IPAddress acquireAddress(AddressManagementDTO payload){
        int rowsUpdated = ipAddressRepository.setAddressStatusFor(AddressStatus.ACQUIRED,
                                                                  payload.getIpAddress().getIpAddress(),
                                                                  payload.getIpAddress().getSubnetMask(),
                                                                  payload.getIpAddress().getIpVersion());
        if(rowsUpdated > 0){
            payload.getIpAddress().setAddressStatus(AddressStatus.ACQUIRED);
            return payload.getIpAddress();
        }
        return null;
    }

    @Override
    public IPAddress releaseAddress(AddressManagementDTO payload){
        int rowsUpdated = ipAddressRepository.setAddressStatusFor(AddressStatus.AVAILABLE,
                                                                  payload.getIpAddress().getIpAddress(),
                                                                  payload.getIpAddress().getSubnetMask(),
                                                                  payload.getIpAddress().getIpVersion());
        if(rowsUpdated > 0){
            payload.getIpAddress().setAddressStatus(AddressStatus.AVAILABLE);
            return payload.getIpAddress();
        }
        return null;
    }

}
