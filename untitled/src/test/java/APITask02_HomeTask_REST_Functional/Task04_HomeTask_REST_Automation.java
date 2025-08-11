package APITask02_HomeTask_REST_Functional;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class Task04_HomeTask_REST_Automation {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://simple-books-api.glitch.me/";
    }

    @Test
    public void get1(){
        given()
                .contentType("application/json")
                .when()
                .get("/status")
                .then()
                .statusCode(200)
                .body("status", equalTo("OK"))
                .log().all();

    }
    @Test
    public void get2(){
       Response rs =  given()
        .contentType("application/json")
                .when()
                .get("/books");
       int status = rs.statusCode();
       Assert.assertEquals(status,200);
       int size = rs.jsonPath().getList("books").size();
       Assert.assertTrue(size >=1);
       JSONArray js = new JSONArray(rs.asString());
       for(int i=0;i<size;i++)
       {
          String type = js.getJSONObject(i).get("type").toString();
          String name = js.getJSONObject(i).get("name").toString();
          System.out.println(type + " " + name);
       }
    }

    @Test
    public void get3(){

        given()
                .when()
                .get("/books?type=fiction")
                .then()
                .body("type", hasItem("fiction"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void get4(){

      //  /books/{bookId}
      Response rs =   given()
                .pathParam("bookId",1)
                .when()
                .get("/books/{bookId}");

      int status = rs.statusCode();
      Assert.assertEquals(status,200);
      JSONObject js = new JSONObject(rs.asString());
          String type = js.get("type").toString();
          String name = js.get("name").toString();
          boolean stockavailable = (boolean) js.get("available");
          System.out.println(type + " " + name + " " + stockavailable);


    }
    @Test
    public void token(){
        String s = "{\n" +
                "  \"clientName\": \"TestUser\",\n" +
                "  \"clientEmail\": \"testuser@example.com\"\n" +
                "}\n";
      given()
        .contentType("application/json")
                .body(s)
                .when()
                .post("/api-clients")
              .then()
              .log().all();
     // int status = rs.statusCode();
     // Assert.assertEquals(status,201);

    }
}
