package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class DifferentWaysToRefreshThePage {
    public static void main(String[] args) {
        // javascript reload
        WebDriver driver = new ChromeDriver();
        // RemoteWebElement
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location.reload()");
        // navigate refresh
        driver.navigate().refresh();
        // navigate to currentURL
        String currURL = driver.getCurrentUrl();
        driver.navigate().to(currURL);
    }
}
