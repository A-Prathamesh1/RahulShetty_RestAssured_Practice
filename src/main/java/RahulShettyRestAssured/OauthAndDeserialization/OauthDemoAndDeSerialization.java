package RahulShettyRestAssured.OauthAndDeserialization;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class OauthDemoAndDeSerialization {
    // Auth server serving the access token
    String token = "";
    @Test
    public void getAccessToken(){
        baseURI = "https://rahulshettyacademy.com";
        String res = given()
                .formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .log().all()
                .when()
                .post("oauthapi/oauth2/resourceOwner/token")
                .then()
                .assertThat().statusCode(200).extract().response().asString();
        JsonPath jp = new JsonPath(res);
        token = jp.getString("access_token");
        System.out.println("token: " + token);
    }
    @Test(dependsOnMethods = {"getAccessToken"})
    public void getCourseDetails(){
        baseURI = "https://rahulshettyacademy.com";
        CourseDetails resCourse = given()
                .queryParam("access_token",token)
                .when()
                .get("oauthapi/getCourseDetails")
                .then()
                .extract().response().as(CourseDetails.class);

        System.out.println("response: " + resCourse.getInstructor());
        System.out.println("linkedIn: " + resCourse.getLinkedIn());
        // get the course price of courseTitle": "Appium-Mobile Automation using Java
        System.out.println("price of \"Appium-Mobile Automation using Java\": " + resCourse.getCourses().getMobile().getFirst().getPrice());
        // get the price of courseTitle": "Appium-Mobile Automation using Java
        List<ApiItem> listOfAPICourses = resCourse.getCourses().getApi();
        for(int i = 0 ; i < listOfAPICourses.size(); i++){
            if(resCourse.getCourses().getApi().get(i).getCourseTitle().equals("SoapUI Webservices testing")){
                System.out.println("SoapUI Webservices testing price: " + resCourse.getCourses().getApi().get(i).getPrice());
            }
        }

        // get course titles from webAutomation
        String[] coursesExpected = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        List<String> expectedCourseTitles = new ArrayList<>(Arrays.asList(coursesExpected));
        List<WebAutomationItem> listOfWebAutoCourses = resCourse.getCourses().getWebAutomation();
        System.out.println("List of webautmation courses: ");
        List<String> actualWebAutomationTitles = new ArrayList<>();
        for(WebAutomationItem webCourse: listOfWebAutoCourses){
           actualWebAutomationTitles.add(webCourse.getCourseTitle());
            System.out.println(webCourse.getCourseTitle());
        }

        Assert.assertEquals(expectedCourseTitles,actualWebAutomationTitles,"Failed to validate the actual course list");
    }
}
