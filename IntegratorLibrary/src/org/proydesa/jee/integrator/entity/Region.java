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
//@Entity(name = "Region")
//@Table(name = "REGIONS")
public class Region implements Serializable{
    
//    @Id
//    @Column(name = "REGION_ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private double regionId;
    
//    @Column(name = "REGION_NAME", nullable = true)
    private String name;
    
//    @OneToMany(mappedBy = "Customer", targetEntity = Country.class, fetch = FetchType.EAGER)
    private List<Country> countries = Collections.EMPTY_LIST;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public double getRegionId() {
        return regionId;
    }

    public void setRegionId(double regionId) {
        this.regionId = regionId;
    }
}
