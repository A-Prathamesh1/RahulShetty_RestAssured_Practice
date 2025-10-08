package RahulShettyRestAssured;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static RahulShettyRestAssured.Payload.addBookPayload;
import static io.restassured.RestAssured.*;

/*
 * how to create dynamic payload for the request body
 *
 * */
public class DynamicJsonLibraryAPI {
//    ExcelReader er = new ExcelReader();

    @Test(dataProvider = "aisleAndisbn")
    public void addBook(String isbn, String aisle) throws IOException {
        List<String> addBookData = ExcelReader.getDataForTest("AddBook");

        HashMap<String, String> payload = new HashMap<>();
        payload.put("name", addBookData.get(1));
        payload.put("isbn", addBookData.get(2));
        payload.put("aisle", addBookData.get(3));
        payload.put("author", addBookData.get(4));

        baseURI = "https://rahulshettyacademy.com";
        String res = given()
                .contentType("application/JSON")
                .body(payload)//addBookPayload(aisle, isbn)
                .when()
                .post("Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jp = new JsonPath(res);
        System.out.println("Response: " + jp.prettyPrint());
        String id = jp.get("ID");
        System.out.println("ID: " + id);
        String msg = jp.getString("Msg");
        System.out.println("msg: " + msg);
    }

    @DataProvider(name = "aisleAndisbn")
    public Object[][] getData() {
        return new Object[][]{{"abcd", "1234"},
                {"pqrt", "4321"},
                {"stuv", "4567"}};
    }

}
