package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToParentWindow {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.switchTo().defaultContent();// switches to first frame or main document when there are multiple iframes
        driver.switchTo().parentFrame();

        driver.switchTo().window("");// switches to window specific handle
    }
}
