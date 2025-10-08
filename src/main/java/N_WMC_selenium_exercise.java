import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class N_WMC_selenium_exercise {
    public static void main(String[] args) {
        try {
            WebDriver driver = new ChromeDriver();

            driver.get("https://www.w3schools.com/html/html_tables.asp");

            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10,SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='customers']//tr[2]")));

            //WebElement table = driver.findElement(By.xpath("//table[@id='customers']//tr[2]"));
            List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tr"));
            List<List<String>> tableList = new ArrayList<>();
            for(int i = 2; i < row.size(); i++){
                List<String> rowEle = new ArrayList<>();
                for(int j = 1; j <= 3; j++){
                    WebElement e = driver.findElement(By.xpath("//table[@id='customers']//tr["+ i +"]//td[" + j + "]"));
                    rowEle.add(e.getText());
                }
                tableList.add(rowEle);
            }
            System.out.println(tableList);
            driver.quit();
        }catch(Exception e){
            System.out.println("Exception message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
