import RahulShettyRestAssured.SerializationMaps.Location;
import RahulShettyRestAssured.SerializationMaps.MapPayload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class SerializationMapsReqSpecBuilder {
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


        ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)//"application/JSON"
                .addQueryParam("key","qaclick123").build();

        req = given().spec(req).body(mp);

        String response = req.when()
                .post("maps/api/place/add/json")
                .then()
                .spec(res).extract().response().asString();

        System.out.println("response: " + response);


    }
}
