package com.spartaglobal.RestAssuredPostcode;

import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class singlePostcodesTest
{

    private static Response singlePostcodeResponse;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";
        singlePostcodeResponse = get("rm96aj");
    }

    @Test
    public void postcodeRequestIsSuccessful() {
        singlePostcodeResponse
                .then()
                .statusCode(200)
                .body("result.postcode", equalTo("RM9 6AJ"));
    }
}
