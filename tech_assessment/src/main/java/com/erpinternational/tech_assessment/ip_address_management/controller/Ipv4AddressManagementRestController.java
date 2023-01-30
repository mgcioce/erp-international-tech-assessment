package com.erpinternational.tech_assessment.ip_address_management.controller;

import com.erpinternational.tech_assessment.ip_address_management.controller.model.AddressManagementDTO;
import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;
import com.erpinternational.tech_assessment.ip_address_management.service.IpAddressManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/ip-address-management/v1/addresses"})
public class Ipv4AddressManagementRestController implements AddressManagementRestController{

    @Autowired
    private IpAddressManagementService ipAddressManagementService;

    @Override
    @RequestMapping(method = {RequestMethod.POST},consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AddressManagementDTO> addressCreationViaCidrBlock( @RequestHeader(HttpHeaders.ACCEPT) String acceptHeader,
                                                                             @RequestBody AddressManagementDTO payload) {
        ipAddressManagementService.addIpAddresses(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(method = {RequestMethod.GET},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<IPAddress>> getIpAddresses(){
        List<IPAddress> addresses = ipAddressManagementService.getAddresses();
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }

    @Override
    @RequestMapping(path = "/acquire",method = {RequestMethod.PATCH}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IPAddress> acquireIpAddress(@RequestBody AddressManagementDTO payload){
        IPAddress ipAddress = ipAddressManagementService.acquireAddress(payload);
        if (ipAddress == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ipAddress,HttpStatus.OK);
    }


    @RequestMapping(path = "/release",method = {RequestMethod.PATCH}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<IPAddress> releaseIpAddress(@RequestBody AddressManagementDTO payload){
        IPAddress ipAddress = ipAddressManagementService.releaseAddress(payload);
        if (ipAddress == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(ipAddress,HttpStatus.OK);
    }

    public Ipv4AddressManagementRestController(IpAddressManagementService ipAddressManagementService) {
        this.ipAddressManagementService = ipAddressManagementService;
    }

    public IpAddressManagementService getIpAddressManagementService() {
        return ipAddressManagementService;
    }

    public void setIpAddressManagementService(IpAddressManagementService ipAddressManagementService) {
        this.ipAddressManagementService = ipAddressManagementService;
    }
}
