package com.erpinternational.tech_assessment.ip_address_management.controller.model;

import com.erpinternational.tech_assessment.ip_address_management.model.IPAddress;

public class AddressManagementDTO {

    private String cidrBlock;
    private IPAddress ipAddress;

    public String getCidrBlock() {
        return cidrBlock;
    }

    public void setCidrBlock(String cidrBlock) {
        this.cidrBlock = cidrBlock;
    }

    public IPAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(IPAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}
