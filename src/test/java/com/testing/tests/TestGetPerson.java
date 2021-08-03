package com.testing.tests;

import com.testing.helpers.PersonServicesHelper;
import com.testing.models.PersonPojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestGetPerson {

    private PersonServicesHelper personServicesHelper;

    @BeforeClass
    public void init() {
        personServicesHelper = new PersonServicesHelper();
    }

    @Test
    public void testGetAllPerson() {
        List<PersonPojo> personList = personServicesHelper.getAllPersons();
        Assert.assertNotNull(personList, "List of persons is not empty");
        Assert.assertFalse(personList.isEmpty(), "List of persons is not true");

    }


}
