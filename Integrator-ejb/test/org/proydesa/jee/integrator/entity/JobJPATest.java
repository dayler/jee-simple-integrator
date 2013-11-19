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
    
    private static EntityManager entityManager;

    @BeforeClass
    public static void setUpClass() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Integrator-ejbPU");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Integrator-ejbPU");
        assertNotNull("Null factory", factory);
        entityManager = factory.createEntityManager();
    }
    
    @AfterClass
    public static void tearDownClass() {
        entityManager = null;
    }
    
    @Before
    public void setUp() {
        // No op
    }
    
    @After
    public void tearDown() {
        // No op
    }
    
    @Test
    public void createRetrieveAndDeleteJobEntity() {
        // Create stub job
        Job myJob = new Job();
        myJob.setJobId("test");
        myJob.setTitle("none");
        myJob.setMinSalary(100);
        myJob.setMaxSalary(2000);
        
        // Try to presist
        entityManager.persist(myJob);
        
        // Try to retrieve
        Query query = entityManager.createQuery("select * from JOBS", Job.class);
        assertNotNull("Query is null", query);
        List<Job> jobs = query.getResultList();
        assertNotNull("Jobs is null", jobs);
        assertFalse("Jobs is empty", jobs.isEmpty());
 
        // Try to delete
        entityManager.remove(jobs);
    }
    
    private static Map<String, String> getEntityManagerConfig() {
        Map<String, String> config = new HashMap<String, String>();
//        config.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/MyDb");
        config.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/staffRepository");
        config.put("hibernate.connection.username", "root");
        config.put("hibernate.connection.password", "control*88");
        config.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect#sthash.RXzLnfb9.dpuf");
        config.put("hibernate.show_sql", "true");
        
        return config;
//emf = Persistence.createEntityManagerFactory("MyPU-junit", config);
//em = emf.createEntityManager();
    }
}
