package com.testing.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.testing.constants.Endpoints;
import com.testing.models.PersonPojo;
import com.testing.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;


public class PersonServicesHelper {

    private static String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static String PORT = ConfigManager.getInstance().getString("port");


    public PersonServicesHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }


    public List<PersonPojo> getAllPersons() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_PERSON)
                .andReturn();

        Type type = new TypeReference<List<PersonPojo>>() {
        }.getType();

        List<PersonPojo> personPojosList = response.as(type);
        return personPojosList;

    }


    public Response createPerson() {
        PersonPojo person = new PersonPojo();
        person.setId("12");
        person.setFirstName("Test");
        person.setLastName("Test123");
        person.setAddress("1fdsfsd");
        person.setAge(12);
        person.setPhone("123-123-123");

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(Endpoints.CREATE_PERSON)
                .andReturn();

        Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_CREATED, "Created");

        return res;
    }

    public Response updatePerson(Integer id) {
        PersonPojo person = new PersonPojo();
        person.setId("121");
        person.setFirstName("Testdd");
        person.setLastName("Test123dd");
        person.setAddress("1fdsfsddd");
        person.setAge(122);
        person.setPhone("123-123-123d");

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParams("id", id)
                .when()
                .body(person)
                .post(Endpoints.UPDATE_PERSON)
                .andReturn();

        Assert.assertTrue(res.getStatusCode() == HttpStatus.SC_CREATED);
        return res;
    }

    public Response deletePerson(Integer id) {

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParams("id", id)
                .log().all()
                .when()
                .delete(Endpoints.DELETE_PERSON)
                .andReturn();

        Assert.assertTrue(res.getStatusCode() == HttpStatus.SC_OK);
        return res;
    }


}
