package APITask02_HomeTask_REST_Functional;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import groovy.json.JsonToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Task03_HomeTask_REST_Automation {



    int id;
    String ids;

    public Task03_HomeTask_REST_Automation() throws FileNotFoundException {
    }

    @Test
    public void post() throws FileNotFoundException {
String jsondata ="{\n" +
        "  \"id\": 12345,\n" +
        "  \"category\": {\n" +
        "    \"id\": 1,\n" +
        "    \"name\": \"dog\"\n" +
        "  },\n" +
        "  \"name\": \"snoopie\",\n" +
        "  \"photoUrls\": [\n" +
        "    \"string\"\n" +
        "  ],\n" +
        "  \"tags\": [\n" +
        "    {\n" +
        "      \"id\": 0,\n" +
        "      \"name\": \"string\"\n" +
        "    }\n" +
        "  ],\n" +
        "  \"status\": \"pending\"\n" +
        "}";

        Response rs = given()
                .contentType(ContentType.JSON)
                .body(jsondata)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

       int id = rs.jsonPath().getInt("id");
        ids = Integer.toString(id);
        System.out.println("ID: " + ids);
        int status = rs.statusCode();
        Assert.assertEquals(status, 200);


    }

    @Test(dependsOnMethods = "post")
    public void get() {

        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/"+ids)
                .then()
                .contentType(ContentType.JSON)
                .body("category.name", equalTo("dog"))
                .body("name", equalTo("snoopie"))
                .body("status", equalTo("pending"));


    }

    @Test
    public void get2() {
        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users");

        int status = rs.statusCode();
        Assert.assertEquals(status, 200);
        int idsize = rs.jsonPath().getList("$").size();
        Assert.assertTrue(idsize > 3);
        JSONArray js = new JSONArray(rs.asString());
        boolean v = false;
        for (int i = 0; i < idsize; i++) {

            String s = js.getJSONObject(i).get("name").toString();
            if (s.contains("Ervin Howell")) {
                v = true;
                break;
            } else {
                v = false;
            }
        }
        System.out.println(v);


    }

}
