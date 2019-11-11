package com.spartaglobal.RestAssuredPostcode;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class mulitplePostcodeTest {

    private static String postcodeJson = "{\"postcodes\": [\"rm9 6aj\", \"se3 8pf\"]}";
    private static JsonPath multiplePCResponse;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";

        multiplePCResponse =
                given()
                .contentType(ContentType.JSON)
                .body(postcodeJson)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
    }

    @Test
    public void exampleJSONPath(){
        System.out.println(multiplePCResponse.get("status").toString());
        Assert.assertEquals(200, multiplePCResponse.getLong("status"));
    }

    @Test
    public void checkPostcodeResponse(){
        Assert.assertEquals("RM9 6AJ",multiplePCResponse.getString("result[0].result.postcode"));
    }
}
