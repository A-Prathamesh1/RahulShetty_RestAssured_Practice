import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class P_PS_Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hdfcbank.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[text()='Login'])[1]"))).perform();


        driver.findElement(By.xpath("//a[text()='NetBanking']")).click();
        Thread.sleep(5000);

        Set<String> windows = driver.getWindowHandles();
        String parent_window = driver.getWindowHandle();
        System.out.println("Parent window: " + parent_window);
        for (String window : windows) {
            if (!window.equals(parent_window)) {
                driver.switchTo().window(window);
                System.out.println("know more window: " + window);
            }
        }
        Thread.sleep(5000);

        System.out.println("waiting for know more");

        driver.switchTo().frame("login_page");

        WebElement link = driver.findElement(By.xpath("(//span[@class='lightbluecolor'])[7]//a"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(link).click().perform();

        System.out.println(driver.getCurrentUrl());
        Set<String> windows1 = driver.getWindowHandles();
        String parent_window1 = driver.getWindowHandle();
        for (String window : windows1) {
            if (!window.equals(parent_window1) && !window.equals(parent_window)) {
                driver.switchTo().window(window);
                System.out.println("lang window: " + window);
            }
        }

        Thread.sleep(5000);
        List<WebElement> langs = driver.findElements(By.xpath("(//div[@class='be-ex-content'])[1]//child::a"));
        List<String> langsList = new ArrayList<>();
        for (WebElement lang : langs) {
            langsList.add(lang.getText());
        }
        System.out.println(langsList);

        if (!langsList.isEmpty()) {
            driver.switchTo().window(parent_window);
            System.out.println("switched to parent Window!");
        }
    }
}
