package restAssured;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class MainCRUD{
    // validate the schema of response
    //@Test
    public void getTest(){
        baseURI = "https://reqres.in/api";
        given()
                .header("x-api-key","reqres-free-v1")
                .contentType("application.JSON")
                .queryParam("page","1")
                .queryParam("per_page","4")
        .when()
                .get("/resource")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("response-schema.json"));
    }
    // get request
    @Test
    public void getUserWithIDTest(){
        baseURI = "https://reqres.in/api";
        Response res = given()
                .contentType("application.JSON")
                .header("x-api-key","reqres-free-v1")
                .pathParam("id",1)
                .when()
                .get("/users/{id}");
//                .then()
//                .log().all();
//                .assertThat()
//                .statusCode(200);
        int id = res.jsonPath().getInt("data.id");
        int statusCode = res.getStatusCode();
        System.out.println("statusCode: " + statusCode);
        System.out.println("response payload: " + res.prettyPrint());
        System.out.println("Id: " + id);
        Assert.assertEquals(statusCode, 200,"Could not verify status code");
        Assert.assertEquals(id, 1,"response do not have Id/correct ID");

    }
    // put request
    @Test
    public void putRequest(){
        User u = new User("UpdatedPrat","updated@test.com","updated@123");
        Gson gson = new Gson();
        baseURI = "https://reqres.in/api";
        Response res =
        given()
                .contentType("application/json")
                .header("x-api-key","reqres-free-v1")
                .pathParam("id",1)
                .body(gson.toJson(u))
                .when()
                .put("/users/{id}");
    int statusCode = res.statusCode();
    System.out.println("Status Code: " + statusCode);
    String prettyRes = res.prettyPrint();
    System.out.println("response: " + prettyRes);
    String userName = res.jsonPath().getString("username");
    System.out.println("username: " + userName);
    Assert.assertEquals(statusCode,200,"Failed to verify status code");
    Assert.assertEquals(userName, "UpdatedPrat", "Failed to update the username");
    String email = res.jsonPath().getString("email");
    System.out.println("email: " + email);
    Assert.assertEquals(email, "updated@test.com", "Failed to update the email");
    String pass = res.jsonPath().getString("password");
    System.out.println("pass: " + pass);
    Assert.assertEquals(pass, "updated@123", "Failed to update the password");
}
    //post request
    //@Test
    public void createUserPost(){
        baseURI = "https://reqres.in/api";
        User u = new User("prat", "eve.holt@reqres.in","cityslicka");
        Gson gson = new Gson();
        String userPayload = gson.toJson(u);
        Response response =
        given()
                .contentType("application/JSON")
                .header("x-api-key","reqres-free-v1")
                .body(userPayload)
        .when()
                .post("/register")
        .then()
                .log().all()
                .extract().response();
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        Assert.assertEquals(response.jsonPath().get("username"), "prat", "Failed to create the username");
    }
    // patch req
    @Test
    public void patchRequest(){
        User user = new User("PatchedUserName","PatchedEmail","patchedPass");
        Gson gson = new Gson();

        baseURI = "https://reqres.in/api";
        Response res = given()
                .contentType("application/JSON")
                .header("x-api-key","reqres-free-v1")
                .body(gson.toJson(user))
                .pathParams("id",1)
        .when()
                .patch("/users/{id}");
        System.out.println("res:" + res.prettyPrint());
        Assert.assertEquals(res.statusCode(), 200, "Status code is not 200");
        Assert.assertEquals(res.jsonPath().get("username"),user.getUsername(),"Failed to patch the username");
        Assert.assertEquals(res.jsonPath().get("password"),user.getPassword(),"Failed to patch password");
        Assert.assertEquals(res.jsonPath().get("email"), user.getEmail(),"Failed to patch email");
    }
    // delete req
    @Test
    public void deleteRequest(){
        baseURI = "https://reqres.in/api";
        Response res = given()
                .contentType("application/JSON")
                .header("x-api-key","reqres-free-v1")
                .pathParam("id",1)
        .when()
                .delete("/users/{id}")
        .then()
                .extract()
                .response();
        Assert.assertEquals(res.statusCode(),204, "Failed to delete the record");
        System.out.println("delete response: " + res.prettyPrint());
    }


}