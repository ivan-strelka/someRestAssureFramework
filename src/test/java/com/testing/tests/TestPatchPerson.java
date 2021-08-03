package com.testing.tests;

import com.testing.helpers.PersonServicesHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPatchPerson {

    private PersonServicesHelper personServicesHelper;

    @BeforeClass
    public void init() {
        personServicesHelper = new PersonServicesHelper();
    }

    @Test
    public void updatePersonTest() {
        String id = personServicesHelper.updatePerson(12).jsonPath().getString("id");
        Assert.assertNotNull(id, "Updated");

    }
}
