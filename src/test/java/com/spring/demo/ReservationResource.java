package com.spring.demo;
import com.spring.demo.rest.ResourceConstants;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationResource {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception{

        RestAssured.port = port;
        RestAssured.basePath = ResourceConstants.USER_V1;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void test(){

        given().when().get("/" + 1).then().statusCode(200);
        given().when().get("/"+"?checkin=2019-07-21&checkout=2019-07-25").then().statusCode(200);

    }

    @Test
    public void testCreateReservation(){

        RequestSpecification request = given();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("roomId", 1);
            jsonObject.put("checkin","2019-07-10");
            jsonObject.put("checkout","2019-07-13");
        } catch (JSONException e) {
            fail(e.getMessage());
        }

        request.header(new Header("Content-Type", "application/json"));
        request.body(jsonObject.toString());
        Response response = request.post("/");
        int statusCode = response.statusCode();
        Assert.assertEquals(201, statusCode);

        String checkin = response.jsonPath().getString("checkin");
        String checkout = response.jsonPath().getString("checkout");

        Assert.assertEquals(checkin, "2019-07-10");
        Assert.assertEquals(checkout,"2019-07-13");
    }
}
