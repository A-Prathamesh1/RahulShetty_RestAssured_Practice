package RahulShettyRestAssured;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static RahulShettyRestAssured.Payload.addPlacePayload;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

//import static java.nio.file.Files;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.Matchers.*;
public class HttpCRUD {
    String place_id = "";
    // file content > String > bytes > string

    @Test(priority = 0)
    public void addPlaceTest() throws IOException {
        baseURI = "https://rahulshettyacademy.com";
        String s = new String(readAllBytes(Paths.get("C:\\Users\\praausek\\Documents\\Automation Workspace\\Selenium Maven Intellij\\PracticeProject\\src\\main\\java\\RahulShettyRestAssured\\addPlace.json")));
//        Response res =
           String response = given()
                .contentType("application/JSON")
                .queryParam("key","qaclick123")
                .body(s)//;addPlacePayload()
                .when()
                        .post("maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();//;
//        System.out.println("res: " + res.prettyPrint());
//        place_id = res.jsonPath().get("place_id");
//        System.out.println("place_id: " + place_id);
//        Assert.assertEquals(res.statusCode(), 200, "Failed to add place");
        System.out.println(response);
        JsonPath jp1 = new JsonPath(response);
        place_id = jp1.getString("place_id");
        System.out.println(">>>>>>added place_id: " + place_id);
    }
    String newAddress = "B-602 Dayal Heights";
    //@Test(priority = 1, dependsOnMethods = {"addPlaceTest"})
    public void updatePlace(){
        baseURI = "https://rahulshettyacademy.com";

        String res = given().log().all()
                .contentType("application/JSON")
                //.queryParams("key","qaclick123")
                .body("{\n" +
                        "\"place_id\":\""+place_id+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when()
                    .put("maps/api/place/update/json")
                .then().log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("msg",equalTo("Address successfully updated"))
                    .extract()
                    .response()
                    .asString();

        JsonPath jp2 = new JsonPath(res);
        System.out.println("msg: " + jp2.getString("msg"));
    }

    //@Test(priority = 2, dependsOnMethods = {"updatePlace"})
    public void getPlace(){
        baseURI = "https://rahulshettyacademy.com";
        String res = given()
                .queryParams("key","qaclick123")
                .queryParams("place_id", place_id)
                .when()
                .get("maps/api/place/get/json")
        .then()
                .log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath jp3 = new JsonPath(res);
        String address = jp3.getString("address");
        System.out.println(">>>>>>address: " + address);
        Assert.assertEquals(address, newAddress, "Failed to update the address");
    }
}
