package APITask02_HomeTask_REST_Functional;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;


public class Task02_HomeTask_REST_Functional {
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void webservice() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("", hasSize(100));
    }

    @Test
    public void comments() {
        Response rs = given()
                .contentType("application/json")
                .when()
                .get("/comments");
        int size = rs.jsonPath().getList("$").size();
        System.out.println("Comments " + size);


    }

    @Test
    public void albums() {
        Response rs = given()
                .when()
                .get("/albums");
        int size = rs.jsonPath().getList("$").size();
        System.out.println("albums " + size);

    }

    @Test
    public void photos() {
        Response rs = given()
                .when()
                .get("/photos");
        int size = rs.jsonPath().getList("$").size();
        System.out.println("photos " + size);

    }

    @Test
    public void todos() {
        Response rs = given()
                .when()
                .get("/todos");
        int size = rs.jsonPath().getList("$").size();
        System.out.println("todos " + size);
    }

    @Test
    public void users() {
        Response rs = given()
                .when()
                .get("/users");
        int size = rs.jsonPath().getList("$").size();
        System.out.println("users " + size);
    }


}

