package com.testing.tests;

import com.testing.helpers.PersonServicesHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPostPerson {

    private PersonServicesHelper personServicesHelper;


    @BeforeClass
    public void init() {
        personServicesHelper = new PersonServicesHelper();
    }


    @Test
    public void createPerson() {
        String id = personServicesHelper.createPerson().jsonPath().getString("id");
        Assert.assertNotNull(id, "Person is not null");
        Assert.assertFalse(id.isEmpty(), "List of persons is not true");
    }
}
