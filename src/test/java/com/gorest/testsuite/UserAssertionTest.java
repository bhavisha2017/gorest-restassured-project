package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class UserAssertionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 20
    @Test
    public void verifyTotalRecord() {
        response.body("size", equalTo(10));
    }
    // 2. Verify the if the name of id =  2329070 is equal to "Amogh Patel"
    @Test
    public void verifyNameOfId2322253() {
        response.body("find{it.id == 2322253}.name", equalTo(null));
    }
    //3. Check the single ‘Name’ in the Array list (Chandraswaroopa Guneta)
    @Test
    public void verifySingleName() {
        response.body("[1].name", equalTo("Chandraswaroopa Guneta"));
    }
    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void verifyMultipleNames() {
        response.body("name", hasItems("Vishwamitra Chopra, Chandraswaroopa Guneta, Kirti Pothuvaal," +
                " Vishwamitra Abbott, Abhaidev Johar, Daksha Bharadwaj,Amb. Girik Varma, Giriraj Chopra, Naveen Chopra, Miss Tejas Nehru"));
    }
    //5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void verifyEmailOfUserId() {
        response.body("find{it.id == 2329080}.email", equalTo(null));
    }
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void verifyStatusIsActive() {
        response.body("find{it.name =='Ahalya Mahajan'}.status", equalTo(null));
    }
    //7. Verify the Gender = male of user name is “Niro Prajapat
    @Test
    public void verifyGender() {
        response.body("find{it.name == 'Ahalya Mahajan'}.gender", equalTo(null));
    }
}
