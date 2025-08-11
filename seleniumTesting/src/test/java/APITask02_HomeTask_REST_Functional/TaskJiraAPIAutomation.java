package APITask02_HomeTask_REST_Functional;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class TaskJiraAPIAutomation {


    String apitoken = "ATATT3xFfGF09Y_VmHCerX1-9_50awMf2G30MjUEIGm8NrWJmvvPECzqs4VXU3sa-klPXU3MQgdTC7Miumw91JSIILCmbxoXDJboGUx_7WiSJ7RtxlQttZ9QQl8yi6FtQjP54LlJ65axtfejHBupeC2kBOCjMn8Qzq7VCJaz8Wq-TUhxVrxrVBc=91DF1078";

    @Test(priority = 1)
    public void create(ITestContext context) throws FileNotFoundException {
        File f = new File("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\seleniumTesting\\src\\test\\java\\APITask02_HomeTask_REST_Functional\\taskjira.json");
        FileReader fr = new FileReader(f);
        JSONTokener tokener = new JSONTokener(fr);
        JSONObject obj = new JSONObject(tokener);
        Response rs = given()
                .auth().preemptive().basic("shivakumar_bantu@epam.com", apitoken)
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .body(obj)
                .when()
                .post("https://shivakumarbantu.atlassian.net/jira/software/projects/JIR/boards/34/backlog/rest/api/3/issue")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

    }

    @Test(priority = 2)

    public void update(ITestContext context) throws FileNotFoundException {
        ///rest/api/3/issue/{issueIdOrKey}
        File f = new File("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\seleniumTesting\\src\\test\\java\\APITask02_HomeTask_REST_Functional\\taskjira.json");
        FileReader fr = new FileReader(f);
        JSONTokener tokener = new JSONTokener(fr);
        JSONObject obj = new JSONObject(tokener);
        given()
                .auth().preemptive().basic("shivakumar_bantu@epam.com", apitoken)
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .pathParams("issueIdOrKey", "5b109f2e9729b51b54dc274d")
                .body(obj)
                .when()
                .put("https://shivakumarbantu.atlassian.net/jira/software/projects/JIR/boards/34/backlog//rest/api/3/issue/{issueIdOrKey}")
                .then()
                .statusCode(200);
    }

    @Test(priority = 3)

    public void addattachment() {
        String s = "C:\\Users\\ShivaKumarBantu\\Downloads\\Screenshot 2025-08-11 131213.png";
        given()
                .auth().preemptive().basic("shivakumar_bantu@epam.com", apitoken)
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .body(s)
                .when()
                .put("https://shivakumarbantu.atlassian.net/jira/software/projects/JIR/boards/34/backlog/rest/api/3/issue")
                .then()
                .statusCode(200);
    }

    @Test(priority = 4)

    public void delete() {
        given()
                .auth().preemptive().basic("shivakumar_bantu@epam.com", apitoken)
                .header("Content-Type", "application/json")
                .contentType("application/json")
                .pathParams("issueIdOrKey", "5b109f2e9729b51b54dc274d")
                .when()
                .delete("https://shivakumarbantu.atlassian.net/jira/software/projects/JIR/boards/34/backlog//rest/api/3/issue/{issueIdOrKey}")
                .then()
                .statusCode(200);

    }


}


