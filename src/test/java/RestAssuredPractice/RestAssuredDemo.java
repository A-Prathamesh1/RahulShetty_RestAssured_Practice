package RestAssuredPractice;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {
    public static void main(String[] args) {
        // how to test XML & form data
        String jsonPayload = "{\"name\":\"Prathamesh\"}";
        String xmlPayload = "<name>Prathamesh</name>";

        given()
                .contentType("application/xml")
                .body(xmlPayload)
                .when()
                .post("/osts")
                .then()
                .statusCode(201)
                .contentType("application/xml");

        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", "Uname123")
                .formParam("Pass", "pass123")
                .formParam("email", "Uname@123.com")
                .when()
                .post()
                .then()
                .contentType(containsString("application/x-www-form-urlencoded"));

        // uploading file using multipart
        File f = new File("C:\\Users\\prath\\Documents\\Job\\New Company\\Practice for new Company\\RahulShetty_RestAssured_Practice\\abc.txt");
        given()
                .multiPart(f)
                .multiPart("description", "Test file upload")
                .multiPart("userID", "1")
                .when()
                .post("/upload")
                .then()
                .statusCode(200);

        // Testing response content type
        given()
                .contentType("Application/json")
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .contentType(containsString("json"));


        // Multiple accept content Types
        given()
                .accept("Application/json, Application/xml, Application/x-www-form-urlencoded")
                .when()
                .get()
                .then()
                .statusCode(200);


    }

    // Creating data driven tests using selenium annotation & providing it to rest assured test step
    @DataProvider(name = "postCreationData")
    public Object[][] dataProviderForPostCreation() {
        return new Object[][]{{"uname1", "pass1", "email1@abc.com"}, {"uname2", "pass2", "email2@abc.com"}, {"uname3", "pass3", "email3@abc.com"}};
    }

    @Test(dataProvider = "postCreationData")
    public void createPost(String name, String pass, String email) {
        String payload = "{\"name\":" + name + "," +
                " \"pass\":" + pass + "," +
                " \"email\":" + email + "}";

        given()
                .contentType("Application/json")
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .contentType(containsString("json"))
                .body("name", equalTo(name))
                .body("pass", equalTo(pass))
                .body("email", equalTo(email));

    }

    // logging in rest assured
    @BeforeTest
    public void setuplogging() {
        filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    // logging the request
    @Test
    public void loggingTheRequest() {
        given()
                .log().all() // this will log the request
                .body("payload")
                .when()
                .post("/posts")
                .then()
                .statusCode(200);
    }

    // logging the response
    @Test
    public void loggingTheResponse() {
        given()
                .body("payload")
                .when()
                .post("/posts")
                .then()
                .log().all() // this will log all the response
                .statusCode(200);

    }

    // conditional logging: logging only when its error
    @Test
    public void conditionalLogging() {
        given()
                .when()
                .post()
                .then()
                .log().ifError()
                .statusCode(200);
    }

    // specific logging for headers, params , body
    @Test
    public void specificLogging() {
        given()
                .log().headers()
                .log().params()
                .log().body()
                .body("payload")
                .when()
                .post("post")
                .then()
                .statusCode(201)
                .log().headers()
                .log().body();
    }

    // logging to file
    @Test
    public void loggToFile() throws IOException {
        PrintStream logStream = new PrintStream("log_file.txt");

        given()
                .log().all(logStream.checkError())
                .when().post("/posts")
                .then()
                .log().all(logStream.checkError())
                .statusCode(200);

    }

    @Test
    public void loggingWithRequestResponseSpec() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("")
                .addHeader("ContentType", "Application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThanOrEqualTo(200L), TimeUnit.MILLISECONDS)
                .expectContentType("Application/json")
                .build();

        given()
                .spec(requestSpec)
                .when()
                .post("/posts")
                .then()
                .spec(responseSpec);
    }

    // test status code 200
    @Test
    public void test200StatusCode() {
        given()
                .when()
                .get("posts/1")// successful get request would return 200
                .then()
                .statusCode(200);
    }

    // status code 201
    @Test
    public void statusCode201() {
        given()
                .contentType("Application/json")
                .body("payload")
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }

    // status code 404 not found
    @Test
    public void test404() {
        given()
                .when()
                .get("/posts/9999999999")
                .then()
                .statusCode(404);
    }

    //status code 400 bad request : faulty payload
    @Test
    public void code400BadRequest() {
        given()
                .body("malformed_payload")
                .when()
                .post("/posts")
                .then()
                .statusCode(400);
    }

    // timeouts in restassured : need to be configured in restassuredConfig
    @Test
    public void timeoutTest() {
        given();
                /*.socketTimeout(100)
                .connectionTimeout(5000);*/
    }
}
