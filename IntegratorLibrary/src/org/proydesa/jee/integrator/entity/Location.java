/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
//@Entity(name = "Location")
//@Table(name = "LOCATIONS")
public class Location implements Serializable {
//    @Id
//    @Column(name = "LOCATION_ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private double locationId;
    
//    @Column(name = "STREET_ADDRESS", nullable = true)
    private String streetAddress;
    
//    @Column(name = "POSTAL_CODE", nullable = true)
    private String postalCode;
    
//    @Column(name = "CITY", nullable = false)
    private String city;
    
//    @Column(name = "STATE_PROVINCE", nullable = true)
    private String stateProvince;
    
//    @Column(name = "COUNTRY_ID", nullable = true)
    private String countyId;
    
    // fetch = FetchType.LAZY, mappedBy = "stock"
//    @OneToMany(mappedBy = "LOCATIONS", targetEntity = Department.class, fetch = FetchType.EAGER)
    private List<Department> departments = Collections.EMPTY_LIST;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
