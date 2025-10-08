import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewURL_inNewWindowORTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://www.instagram.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://www.facebook.com");
    }
}
