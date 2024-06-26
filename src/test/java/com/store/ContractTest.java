package com.store;

import in.specmatic.test.SpecmaticJUnitSupport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ContractTest extends SpecmaticJUnitSupport {
    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void setUp() {
        System.setProperty("host", "localhost");
        System.setProperty("port", "8090");
        System.setProperty("endpointsAPI", "http://localhost:8090/actuator/mappings");
        System.setProperty("SPECMATIC_GENERATIVE_TESTS", "true");
        System.setProperty("TEST_ANNOTATIONS", "true");

        context = SpringApplication.run(MainApp.class);
    }

    @AfterAll
    public static void tearDown() {
        context.close();
    }
}