package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostExtractionTest {
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

    //1. Extract the title
    @Test
    public void extractTitle() {
        List<String> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The title are : " + title);
        System.out.println("------------------End of Test---------------------------");

    }
    //2. Extract the total number of record
    @Test
    public void extractTotalRecords() {
        List<Integer> totalNoOfRecords = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total no of records are : " + totalNoOfRecords.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the body of 9th record
    @Test
    public void extract10thRecord() {
        String record = response.extract().path("[9].body");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The body of 9th record :" + record);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the user_id of all the records
    @Test
    public void extractUserIdOfAllRecords() {
        List<Integer>userId = response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The user_id of all the records :" + userId);
        System.out.println("------------------End of Test---------------------------");

    }
    //5. Extract the title of all the records
    @Test
    public void extractTitleOfAllRecords() {
        List<String> records = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  title of all the records :" + records);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void extractTitleOfUserId() {
        List<String> titleOfIds = response.extract().path("findAll{it.user_id == 2272659}.title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  title of all the records :" + titleOfIds);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void extractBodyOfAllRecords() {
        List<String> titleOfId = response.extract().path("findAll{it.id == 39288}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The body of all the records :" + titleOfId);
        System.out.println("------------------End of Test---------------------------");

    }
}
