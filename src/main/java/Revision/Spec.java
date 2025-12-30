package Revision;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class Spec {
    public RequestSpecification getReqSpec() throws FileNotFoundException {
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setContentType("Application/Json")
                .addHeader("accept", "")
                .addPathParam("users", "/users")
                .addFormParam("", "")
                .build();
        return reqSpec;
    }

    public ResponseSpecification getResponseSpec() {
        ResponseSpecification getResSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("Application/JSON")
                .build();
        return getResSpec;
    }

    public void getReq() throws FileNotFoundException {
        given()
                .spec(getReqSpec())
        .when()
                .get("")
        .then()
                .spec(getResponseSpec());

    }
}
