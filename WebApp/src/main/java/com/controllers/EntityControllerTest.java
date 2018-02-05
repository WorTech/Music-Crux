package com.controllers;

import com.models.Entity;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class EntityControllerTest {

    private String URL = "http://localhost:8080/api/entity?name=test&type=label&limit=3";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getEntityResponse() throws Exception{
        System.out.println("Request made to: " + URL);
        List<Entity> entities = restTemplate.getForObject(URL, List.class);
        System.out.println(entities);
    }

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Setting up test . . . ");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Tearing test data down . . .");
    }
}