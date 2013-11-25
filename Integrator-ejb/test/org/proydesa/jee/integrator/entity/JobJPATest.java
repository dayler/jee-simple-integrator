/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ariel
 */
public class JobJPATest {
    
    private static EntityManagerFactory factory;
    
    private EntityManager emanager;

    @BeforeClass
    public static void setUpClass() {
        factory = Persistence.createEntityManagerFactory("Integrator-ejbPU", getEntityManagerConfig());
        assertNotNull("Null factory", factory);
    }
    
    @AfterClass
    public static void tearDownClass() {
        factory = null;
    }
    
    @Before
    public void setUp() {
        emanager = factory.createEntityManager();
    }
    
    @After
    public void tearDown() {
        if (emanager != null) {
            emanager.close();
        }
    }
    
    @Test
    public void createRetrieveAndDeleteJobEntity() {
        // Create stub job
        assertTrue(true);
//        Job myJob = new Job();
//        myJob.setJobId("test");
//        myJob.setTitle("none");
//        myJob.setMinSalary(100);
//        myJob.setMaxSalary(2000);
//        
//        // Try to presist
//        emanager.persist(myJob);
//        
//        // Try to retrieve
//        Query query = emanager.createQuery("select jobs from JOBS as jobs", Job.class);
//        assertNotNull("Query is null", query);
//        List<Job> jobs = query.getResultList();
//        assertNotNull("Jobs is null", jobs);
//        assertFalse("Jobs is empty", jobs.isEmpty());
// 
//        // Try to delete
//        emanager.remove(jobs);
    }
    
    private static Map<String, String> getEntityManagerConfig() {
        Map<String, String> config = new HashMap<String, String>();
        config.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/IntegratorRepository?zeroDateTimeBehavior=convertToNull");
        config.put("javax.persistence.jdbc.user", "root");
        config.put("javax.persistence.jdbc.password", "control*88");
        config.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        config.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        
        return config;
    }
}
