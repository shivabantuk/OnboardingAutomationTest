package APITask02_HomeTask_REST_Functional;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TaskJiraAPIAutomation {


    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-issues/#api-rest-api-3-issue-issueidorkey-get";

    }

    @Test
    public void create(ITestContext context) {
        String data = "{\"fields\":{\"project\":{\"key\":\"PROJ\"},\"summary\":\"Summaryof the defect\",\"description\":\"Descrption\",\"issuetype\":{\"name\":\"Bug\"} }}";
        Response rs = given()
                .body(data)
                .when()
                .post("/rest/api/3/issue")
                .then()
                .statusCode(201)
                .extract().response();

    }

    @Test
    public void update(ITestContext context) {
        int id = (Integer) context.getSuite().getAttribute("id");
        ///rest/api/3/issue/{issueIdOrKey}

        String data = "{\"fields\":{\"project\":{\"key\":\"PROJ\"},\"summary\":\"Summaryof the defect\",\"description\":\"Descrption\",\"issuetype\":{\"name\":\"Bugs\"} }}";

        given()
                .pathParams("issueIdOrKey", id)
                .body(data)
                .when()
                .put("/rest/api/3/issue/"+"{issueIdOrKey}")
                .then()
                .statusCode(200);
    }
    @Test
    public void delete(ITestContext context) {
        int id = (Integer) context.getSuite().getAttribute("id");
        given()
                .when()
                .delete("/rest/api/3/issue/"+"{issueIdOrKey}")
                .then()
                .statusCode(200);
    }


}


