package com.gorest.crudtestpackages;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {


    static String name = "Gorakhanatha Sharma" + TestUtils.getRandomValue();
    static String email = TestUtils.getRandomValue() + "xyz@gmail.com";
    static String gender = "female";
    static String status = "active";



    @Test
    public void test001() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("page","1");
        qParams.put("per_page","20");
        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().log().all().statusCode(201);
    }

    @Test
    public void test002() {

        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().log().all().statusCode(200);


    }
    @Test
    public void test003() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("page","1");
        qParams.put("per_page","20");
        Response response = given()
                .header("Authorization","Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .contentType(ContentType.JSON)
                .when()
                .put("/users/2338258");
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }
    @Test
    public void test004()
    {
        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/2338258");
        response.prettyPrint();
        response.then().statusCode(204);
  }
}