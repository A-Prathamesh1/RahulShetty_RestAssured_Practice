package RahulShettyRestAssured.E_com_E2E;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import   io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EComApiTest {
    LoginResponse loginResponse;
    @Test(priority = 0)
    public void loginTest(){
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)
                .build();

        LoginDetails ld = new LoginDetails();
        ld.setUserEmail("psausekar@gmail.com");
        ld.setUserPassword("Rahulshetty@100%");


        RequestSpecification reqSpec = given().spec(req)
                .body(ld);
        loginResponse = reqSpec.when()
                .post("api/ecom/auth/login")
                .then()
                .extract().response().as(LoginResponse.class);

        System.out.println("token: " + loginResponse.getToken());
        System.out.println("UserID: " + loginResponse.getUserId());

    }

    CreateProdRes createProdReqSpecRes;
    @Test(priority = 1)
    public void createProduct(){
        RequestSpecification createProdReqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization",loginResponse.getToken())
                .build();

        RequestSpecification addProdReqSpec = given()
                .spec(createProdReqSpec)
                .formParam("productName","Laptop")
                .formParam("productAddedBy",loginResponse.getUserId())
                .formParam("productCategory","fashion")
                .formParam("productSubCategory","shirts")
                .formParam("productPrice","11500")
                .formParam("productDescription","Addias Originals")
                .formParam("productFor","women")
                .multiPart("productImage",new File("C:\\Users\\praausek\\Pictures\\Screenshots\\checkList.png"));

        createProdReqSpecRes = addProdReqSpec.when()
                .post("/api/ecom/product/add-product")
                .then().extract().response().as(CreateProdRes.class);

        System.out.println("productId: " + createProdReqSpecRes.getProductId());
        System.out.println("message: " + createProdReqSpecRes.getMessage());
    }
    CreateOrderRes createOrderRes;
    @Test(priority = 2)
    public void createOrder(){
        RequestSpecification specForCrateOrder = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization",loginResponse.getToken())
                .build();
        CreateOrder co = new CreateOrder();
        OrderItems oi = new OrderItems();
        oi.setCountry("India");
        oi.setProductOrderedId(createProdReqSpecRes.getProductId());
        List<OrderItems> orderItemsList = new ArrayList<>();
        orderItemsList.add(oi);
        System.out.println(">>>>> orderItemsList: " + orderItemsList);
        co.setOrders(orderItemsList);
        System.out.println(">>>>> customer order: " + co.getOrders().getFirst());

        RequestSpecification createOrderSpec = given().spec(specForCrateOrder).body(co);

        createOrderRes = createOrderSpec.when()
                .post("/api/ecom/order/create-order")
                .then()
                .extract().response().as(CreateOrderRes.class);

        System.out.println("product Order ID: " + createOrderRes.getProductOrderId());
        System.out.println("orders: " + createOrderRes.getOrders());
    }

    @Test(priority = 3)
    public void deleteProduct(){
        RequestSpecification specForDeleteOrder = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization",loginResponse.getToken())
                .build();

        RequestSpecification specForDelete = given()
                                                .spec(specForDeleteOrder)
                                                .pathParam("productOrderedId",createOrderRes.getProductOrderId().getFirst());
        Response deleteProdRes = specForDelete.when()
                                                .delete("api/ecom/product/delete-product/{productOrderedId}")
                                                .then().extract().response();

        JsonPath jp = new JsonPath(deleteProdRes.asString());
        System.out.println("status code: " + deleteProdRes.statusCode());
        System.out.println("response: " + deleteProdRes.prettyPrint());

        String message  = jp.get("message");
        Assert.assertEquals(message,"Product Deleted Successfully", "Failed to delete the product");

    }
    @Test(priority = 4)
    public void deleteOrder(){
        RequestSpecification deleteOrderReqSpec = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization",loginResponse.getToken())
                .build();

        RequestSpecification deleteOrderReq = given().spec(deleteOrderReqSpec).pathParam("Orders",createOrderRes.getOrders().getFirst());

         Response res = deleteOrderReq.when()
                      .delete("api/ecom/order/delete-order/{Orders}")
                .then()
                    .extract().response();


        String deleteRes = res.asString();
        JsonPath jp = new JsonPath(deleteRes);
        String message  = jp.get("message");
        System.out.println(">>message: " + message);
        Assert.assertEquals(res.statusCode(),200, "Failed to delete the order");
        Assert.assertEquals(message,"Orders Deleted Successfully", "Failed to delete the order");
    }
}
