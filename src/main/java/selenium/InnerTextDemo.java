package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerTextDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\prath\\Documents\\Job\\New Company\\PracticeForNewCompanyFeb26\\src\\test\\java\\index.html");

        System.out.println(driver.findElement(By.id("parent")).getText());
        driver.quit();
    }
}
