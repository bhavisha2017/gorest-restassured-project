package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2";

        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 25
    @Test
    public void verifyTotal(){
        response.body("size()",equalTo(10));
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void verifyTitle(){
        response.body("findAll{it.id == 2338258}.title",hasItems("Ad ipsa coruscus ipsam eos demitto centum"));
    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void verifySingleUserId(){
        response.body("[0].user_id",equalTo(2329083));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void verifyMultipleIds(){
        response.body("id",hasItems(40105, 40098, 40097, 40093, 40089, 40086, 40085, 40084, 40083, 40082));
    }

    @Test
    public void verifyBody(){
        response.body("findAll{it.user_id == 2272663}.body",hasItem("Basium adeptio aut. Suadeo quo caries"));
    }

}
