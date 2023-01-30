package com.erpinternational.tech_assessment.ip_address_management.model;

import javax.persistence.*;

@Entity
public class IPAddress {

    private String ipVersion;
    private String ipAddress;
    private String subnetMask;
    @Enumerated(EnumType.STRING)
    private AddressStatus addressStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public IPAddress(String ipVersion, String ipAddress, String subnetMask, AddressStatus addressStatus) {
        this.ipVersion = ipVersion;
        this.ipAddress = ipAddress;
        this.subnetMask = subnetMask;
        this.addressStatus = addressStatus;
    }



    public IPAddress() {

    }

    public String getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public AddressStatus getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(AddressStatus addressStatus) {
        this.addressStatus = addressStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
