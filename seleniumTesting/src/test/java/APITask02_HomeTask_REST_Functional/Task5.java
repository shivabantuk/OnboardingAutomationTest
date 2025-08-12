package APITask02_HomeTask_REST_Functional;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.StringBuilderWriter;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Task5 {
    //http://localhost:3000/Employees
    int id;

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000/Employees";
    }

    @Test
    public void count() {
        Response rs = given()
                .when()
                .get("http://localhost:3000/Employees");

        int s = rs.jsonPath().getList("$").size();
        System.out.println(s);

    }

    @Test
    public void create(ITestContext context) {
        String data = "{\n" +
                "\"userId\":\"12345\",\n" +
                "\"jobTitleName\":\"Developer\",\n" +
                "\"firstName\":\"Romin\",\n" +
                "\"lastName\":\"Irani\",\n" +
                "\"preferredFullName\":\"Romin Irani\",\n" +
                "\"employeeCode\":\"E1\",\n" +
                "\"region\":\"CA\",\n" +
                "\"phoneNumber\":\"408-1234567\",\n" +
                "\"emailAddress\":\"romin.k.irani@gmail.com\"\n" +
                "}";
        Response rs = given()
                .body(data)
                .when()
                .post("http://localhost:3000/Employees")
                .then()
                .statusCode(201)
                .extract().response();

    }

    @Test(dependsOnMethods = "create")
    public void verify(ITestContext context) {



        Response rs = given()
                .when()
                .get("http://localhost:3000/Employees")
                .then()
                .extract().response();
        JSONArray jsonArray = new JSONArray(rs.getBody().asString());
        for (int i = 0; i < jsonArray.length(); i++) {
            String j = jsonArray.getJSONObject(i).getString("userId");
            if (j.equals("12345")) {
                System.out.println(jsonArray.getJSONObject(i).getString("jobTitleName").toString());

                String s = jsonArray.getJSONObject(i).getString("firstName").toString();
                Assert.assertEquals(s, "Romin");
                System.out.println(jsonArray.getJSONObject(i).getString("lastName").toString());
                System.out.println(jsonArray.getJSONObject(i).getString("preferredFullName"));
                System.out.println(jsonArray.getJSONObject(i).getString("employeeCode"));
                System.out.println(jsonArray.getJSONObject(i).getString("region"));
                System.out.println(jsonArray.getJSONObject(i).getString("phoneNumber"));
                System.out.println(jsonArray.getJSONObject(i).getString("emailAddress"));

            }

        }


    }


}



