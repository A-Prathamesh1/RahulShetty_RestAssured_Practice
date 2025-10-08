package RahulShettyRestAssured.SerializationMaps;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.*;
public class SerializationMaps {
    @Test
    public void addPlace(){
        MapPayload mp = new MapPayload();
        mp.setAccuracy(50);
        mp.setAddress("29, side layout, cohen 09");
        mp.setLanguage("english");
        mp.setName("Frontline house");
        Location l = new Location();
        l.setLat(20.123);
        l.setLng(21.123);
        mp.setLocation(l);
        mp.setPhone_number("1234567890");
        mp.setWebsite("www.google.com");
        mp.setTypes(new ArrayList<>(Arrays.asList("shoe park","shop")));

        baseURI = "https://rahulshettyacademy.com";
        String res = given().log().all()
                .queryParam("key","qaclick123")
                .contentType("application/JSON")
                .body(mp)
                .when()
                .post("maps/api/place/add/json")
                .then()
                .statusCode(200).extract().response().asString();

        System.out.println("response: " + res);


    }
}
