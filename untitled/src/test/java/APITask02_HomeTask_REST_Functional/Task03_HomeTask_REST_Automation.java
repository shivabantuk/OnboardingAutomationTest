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

    String baseUrl = "http://petstore.swagger.io/v2";
    File f = new File("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\untitled\\src\\test\\java\\APITask02_HomeTask_REST_Functional\\task3.json");
    FileReader fileReader = new FileReader(f);
    JSONTokener  jsonTokener = new JSONTokener(fileReader);
    JSONObject data = new  JSONObject(jsonTokener);

    int id;

    public Task03_HomeTask_REST_Automation() throws FileNotFoundException {
    }

    @Test
    public void post() throws FileNotFoundException {



        Response rs = given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        id =  rs.jsonPath().getInt("id");
        int status = rs.statusCode();
        Assert.assertEquals(status, 200);






    }
@Test(dependsOnMethods = "post")
    public void get(){

        given()
                .when()
                .get("https://petstore.swagger.io/v2/pet/"+id)
                .then()
                .contentType(ContentType.JSON)
                .body("category.name", equalTo("dog"))
                .body("name", equalTo("snoopie"))
                .body("status", equalTo("pending"));



    }

    @Test
    public void get2(){
      Response rs =   given()
              .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users");

      int status = rs.statusCode();
      Assert.assertEquals(status, 200);
      int idsize = rs.jsonPath().getList("$").size();
      Assert.assertTrue(idsize>3);
      JSONArray js = new JSONArray(rs.asString());
      boolean v = false;
      for(int i=0;i<idsize;i++)
      {

          String s = js.getJSONObject(i).get("name").toString();
      if(s.contains("Ervin Howell"))
          {
              v = true;
              break;
          }
          else {
              v = false;
          }
      }
      System.out.println(v);


    }

}
