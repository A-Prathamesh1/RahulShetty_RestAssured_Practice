package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ElementInterceptedExceptionHandling {
    public static void main(String[] args) {
        /*
         * ElementInterceptedException: when overlapping element receives click
         * How to click the element?
         * 1. wait for the element to be clickable
         * 2. wait for invisibility of covering element
         * 3. Javascript click
         * 4. using javascript to scroll the element into view
         * */

        // 1. wait for element to be clickable
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        // 2. wait for invisibility of overlapped element
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));

        // 3. javascript click
        WebElement ele = driver.findElement(By.xpath(""));
        ((JavascriptExecutor) driver).executeScript("argument[0].click()", ele);

        // 4. scrollIntoView the element that needs to be clicked
        WebElement ele1 = driver.findElement(By.xpath(""));
        ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView()", ele1);
    }
}
