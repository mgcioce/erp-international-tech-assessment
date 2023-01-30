package com.erpinternational.tech_assessment.ip_address_management.controller;

import com.erpinternational.tech_assessment.ip_address_management.config.ControllerIntegrationTestConfiguration;
import com.erpinternational.tech_assessment.ip_address_management.service.IpAddressManagementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(Ipv4AddressManagementRestController.class)
public class IntegrationIpv4AddressManagementRestControllerTest {

    private static final String IPV4_ADDRESS_MANAGEMENT_REST_CONTROLLER_URI_BASE = "/ip-address-management/v1/addresses";
    private static final String VALID_CIDR_BLOCK = "{\"cidrBlock\":\"10.0.0.0/8\"}";

    @MockBean
    private IpAddressManagementService ipAddressManagementService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void httpPut_ipAddressManagement_v1_addresses_returns4xx(){
        try{
            mockMvc.perform(MockMvcRequestBuilders.put(IPV4_ADDRESS_MANAGEMENT_REST_CONTROLLER_URI_BASE).
                            content(VALID_CIDR_BLOCK).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                    andExpect(MockMvcResultMatchers.status().is4xxClientError());
        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void httpDelete_ipAddressManagement_v1_addresses_returns4xx(){
        try{
            mockMvc.perform(MockMvcRequestBuilders.delete(IPV4_ADDRESS_MANAGEMENT_REST_CONTROLLER_URI_BASE).
                            content(VALID_CIDR_BLOCK).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                    andExpect(MockMvcResultMatchers.status().is4xxClientError());
        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void httpPatch_ipAddressManagement_v1_addresses_returns4xx(){
        try{
            mockMvc.perform(MockMvcRequestBuilders.patch(IPV4_ADDRESS_MANAGEMENT_REST_CONTROLLER_URI_BASE).
                            content(VALID_CIDR_BLOCK).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                    andExpect(MockMvcResultMatchers.status().is4xxClientError());
        } catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void httpPost_ipAddressManagement_v1_addresses_returns201(){
        try{
            mockMvc.perform(MockMvcRequestBuilders.post(IPV4_ADDRESS_MANAGEMENT_REST_CONTROLLER_URI_BASE).
                            content(VALID_CIDR_BLOCK).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE)).
                    andExpect(MockMvcResultMatchers.status().isCreated());
        } catch (Exception e) {
            Assert.fail();
        }

    }
}
