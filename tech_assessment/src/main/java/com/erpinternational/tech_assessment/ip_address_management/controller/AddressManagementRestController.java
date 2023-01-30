package com.erpinternational.tech_assessment.ip_address_management.controller;

import com.erpinternational.tech_assessment.ip_address_management.controller.model.AddressManagementDTO;
import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface AddressManagementRestController {
    @RequestMapping(method = {RequestMethod.POST},consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AddressManagementDTO> addressCreationViaCidrBlock(@RequestHeader(HttpHeaders.ACCEPT) String acceptHeader,
                                                                            @RequestBody AddressManagementDTO payload);

    @RequestMapping(method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<IPAddress>> getIpAddresses();

    @RequestMapping(path = "/acquire",method = {RequestMethod.PATCH}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IPAddress> acquireIpAddress(@RequestBody AddressManagementDTO payload);

    @RequestMapping(path = "/release",method = {RequestMethod.PATCH}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IPAddress> releaseIpAddress(@RequestBody AddressManagementDTO payload);
}
