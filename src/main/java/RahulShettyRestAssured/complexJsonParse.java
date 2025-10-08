package RahulShettyRestAssured;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class complexJsonParse {
    public static void main(String[] args) {
        JsonPath jp = new JsonPath(Payload.coursePrice());
        // 1. Print No of courses returned by API

        int courses_size = jp.getInt("courses.size()");
        System.out.println(courses_size);
        // purchase amount
        int amount = jp.getInt("dashboard.purchaseAmount");
        System.out.println("amount: " + amount);

        // get the title of first course
        String first_course = jp.getString("courses[0].title");
        System.out.println(first_course);

        // 4. Print All course titles and their respective Prices
        for(int i = 0; i < courses_size; i++){
            System.out.println("Course Name: " + jp.getString("courses["+i+"].title"));
            System.out.println("Course Price: " + jp.getInt("courses["+i+"].price"));
        }

//        5. Print no of copies sold by RPA Course
        int copies = jp.getInt("courses[2].copies");
        System.out.println("copies: " + copies);

//        6. Verify if Sum of all Course prices matches with Purchase Amount
        int total = 0;
        for(int i = 0; i < courses_size; i++){
            total += jp.getInt("courses["+i+"].price") * jp.getInt("courses["+i+"].copies");
        }
        Assert.assertEquals(total, amount, "Failed to verify the total prices");
    }

}
