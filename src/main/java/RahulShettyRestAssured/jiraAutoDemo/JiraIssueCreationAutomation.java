package RahulShettyRestAssured.jiraAutoDemo;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class JiraIssueCreationAutomation {
    String id = "";
    @Test
    public void createIssue(){
        baseURI = "https://prathameshausekar1.atlassian.net/";

        String res = given()
                .contentType("application/JSON")
                .header("Authorization","Basic cHJhdGhhbWVzaC5hdXNla2FyMUBnbWFpbC5jb206QVRBVFQzeEZmR0YwQkJfNWszSi1VeVBaSlRsaWt1SnlTcGl0UzlVa3BqWlNCWDFNdVhvb2FiS0pIX25BX2FUOVlfQXl5cFdPVWNMX2VuZHVCSWxTSGhiMTJnUEFFLWhJeVJtQzk5clBzMG1EVGQ2cmN1RElRekRJMDM5TVBGNGZkdms0Q2IycFpmbHJ3eVZrb2FVVmYwZFVYbmZxeXN2XzZlX3hNeVViNE9Xc0tjMUFmR2hrYUNFPTU0RDVFMUEy")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"BTS\"\n" +
                        "       },\n" +
                        "       \"summary\": \"from automation script 1\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}\n")
                .when()
                .post("rest/api/3/issue")
                .then()
                .assertThat().statusCode(201).body("id",notNullValue()).extract().response().asString();

        JsonPath jp = new JsonPath(res);
        id = jp.getString("id");
        System.out.println("Id: " + id);

    }
    @Test(dependsOnMethods = {"createIssue"})
    public void postAttachmentToIssue(){
        baseURI = "https://prathameshausekar1.atlassian.net/";
        String res = given()
                .contentType("multipart/form-data")
                .multiPart("file",new File("C:\\Users\\praausek\\Pictures\\Screenshots\\Screenshot 2025-08-21 094726.png"))
                .header("X-Atlassian-Token","no-check")
                .header("Authorization","Basic cHJhdGhhbWVzaC5hdXNla2FyMUBnbWFpbC5jb206QVRBVFQzeEZmR0YwQkJfNWszSi1VeVBaSlRsaWt1SnlTcGl0UzlVa3BqWlNCWDFNdVhvb2FiS0pIX25BX2FUOVlfQXl5cFdPVWNMX2VuZHVCSWxTSGhiMTJnUEFFLWhJeVJtQzk5clBzMG1EVGQ2cmN1RElRekRJMDM5TVBGNGZkdms0Q2IycFpmbHJ3eVZrb2FVVmYwZFVYbmZxeXN2XzZlX3hNeVViNE9Xc0tjMUFmR2hrYUNFPTU0RDVFMUEy")
                .pathParam("id",id)
                .when()
                .post("rest/api/3/issue/{id}/attachments")
                .then()
                .assertThat().statusCode(200).extract().response().asString();

    }

}
