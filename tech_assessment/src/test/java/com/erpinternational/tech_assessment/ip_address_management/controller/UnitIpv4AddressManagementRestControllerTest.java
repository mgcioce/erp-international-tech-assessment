package com.erpinternational.tech_assessment.ip_address_management.controller;

import com.erpinternational.tech_assessment.ip_address_management.service.IpAddressManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnitIpv4AddressManagementRestControllerTest {

    @Mock
    private IpAddressManagementService ipAddressManagementService;

    @InjectMocks
    private Ipv4AddressManagementRestController ipv4AddressManagementRestController;

    @Test
    public void testPlaceholder(){

    }
}
