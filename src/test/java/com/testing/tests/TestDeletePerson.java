package com.testing.tests;

import com.testing.helpers.PersonServicesHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeletePerson {

    private PersonServicesHelper personServicesHelper;

    @BeforeClass
    public void init() {
        personServicesHelper = new PersonServicesHelper();
    }

    @Test
    public void deletedPerson() {
        Response response = personServicesHelper.deletePerson(123);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_OK, "Created");

    }
}
