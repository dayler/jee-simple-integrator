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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
//@Entity(name = "Conuntry")
//@Table(name = "COUNTRIES")
public class Country implements Serializable {
    
//    @Id
//    @Column(name = "COUNTRY_ID", nullable = false)
    private String countryId;
    
//    @Column(name = "COUNTRY_NAME", nullable = true)
    private String name;
    
//    @Column(name = "REGION_ID")
    private float regionId;
    
//    @OneToMany(mappedBy = "Country", targetEntity = Location.class, fetch = FetchType.EAGER)
    private List<Location> locations = Collections.EMPTY_LIST;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRegionId() {
        return regionId;
    }

    public void setRegionId(float regionId) {
        this.regionId = regionId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
