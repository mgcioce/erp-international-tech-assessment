package com.erpinternational.tech_assessment.ip_address_management.config;

import com.erpinternational.tech_assessment.ip_address_management.controller.AddressManagementRestController;
import com.erpinternational.tech_assessment.ip_address_management.controller.Ipv4AddressManagementRestController;
import com.erpinternational.tech_assessment.ip_address_management.service.IpAddressManagementService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ControllerIntegrationTestConfiguration {

//    @Bean
//    public AddressManagementRestController addressManagementRestController(IpAddressManagementService ipAddressManagementService) {
//        return new Ipv4AddressManagementRestController(ipAddressManagementService);
//    }
}
