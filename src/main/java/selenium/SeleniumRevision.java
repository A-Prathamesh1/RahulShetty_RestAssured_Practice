package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SeleniumRevision {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello world! ");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        // Selenium 4 automatically manages driver
        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));

        //Fluent wait
        FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(20))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait1.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(By.id("")),
                ExpectedConditions.presenceOfElementLocated(By.id("")),
                ExpectedConditions.textToBePresentInElementLocated(By.id(""), ""))
        );

        wait1.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(By.id("")),
                ExpectedConditions.elementToBeClickable(By.id("")),
                ExpectedConditions.numberOfElementsToBe(By.id(""), 10)));

        // javscript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click;", driver.findElement(By.id("")));

        jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("")));

        // headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");


        // findingElement with webDriver
        WebElement el = driver.findElement(By.id(""));
        List<WebElement> elList = driver.findElements(By.id(""));

        // xpath & css selector
        // // relative x-paths , / absolute x-paths
        By.xpath("//button[@id='some_id' and @class='some_class']");
        By.xpath("//input[@placeholder='enter name']");
        By.xpath("//div[contains(@class,'someClass')]");
        // css selector
        By.cssSelector("button#submit.primary");
        By.cssSelector("input[placeholder='enter name']");
        By.cssSelector("div.error-message");

        // dynamic web elements
        // there is button with id that starts with btn_ & rest of the part keeps chainging
        By.xpath("//button[starts-with(@id,'btn_')]");
        // there is button with id that contains 'dynamic' & rest of the part keeps changing
        By.cssSelector("button[@id*='dynamic']");

        // there is button that contains Submit rest of the part keeps changing
        By.xpath("//button[contains(text(),'Submit')]");

        // exact match with text Username
        By.xpath("//label[text()='username']");

        WebElement ele = driver.findElement(By.id(""));
        // Actions by keyboard & mouse
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).click().build().perform();
        actions.click(ele).build().perform();
        actions.doubleClick(ele).perform();
        actions.contextClick(ele).perform();
        actions.dragAndDrop(ele, ele).perform();
        // shift click the ele
        actions.keyDown(Keys.SHIFT).click(ele).keyUp(Keys.SHIFT).perform();

        // Stale element reference exception
        //sol1 : relocate the element after DOM is refreshed
        WebElement ele1 = driver.findElement(By.id(""));
        ele1.click(); // StaleElementException
        ele1 = driver.findElement(By.id(""));
        ele1.click();
        //sol2 : explicitly wait for element to be clickable
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(ele1)).click();

        //sol3 : reattempt clicking as exception occures
        int attempt = 3;
        while (attempt <= 3) {
            try {
                driver.findElement(By.id("")).click();
            } catch (StaleElementReferenceException e) {
                attempt++;
            }
        }

        // precedence of locating strategies fastest first
        By.id("");
        By.name("");
        By.cssSelector("");
        By.xpath("");
        By.linkText("");
        By.partialLinkText("");
        By.className("");
        By.tagName("");

        // difference between driver.navigate() , driver.get(), driver.switchTo()
        driver.get(""); // waits for page to load

        driver.navigate().to("");
        driver.navigate().back(); // uses brow his to navigate back
        driver.navigate().forward(); // just like clicking -> button
        driver.navigate().refresh();

        driver.switchTo().window("");
        driver.switchTo().defaultContent(); // navigates to parent window
        driver.switchTo().alert().accept(); // switches to alert and accepts message
        driver.switchTo().frame("");
        driver.switchTo().parentFrame();

        // switching to alert and accepting dismissing sending keys to prompt message
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        alert.getText();
        alert.sendKeys("");

        // getting all the current window Handles and switching to one of them
        String parent = driver.getWindowHandle();
        Set<String> setOfWinHandles = driver.getWindowHandles();
        for (String winHandle : setOfWinHandles) {
            driver.switchTo().window("");
        }
        driver.switchTo().window(parent);

        // switching to frames
        driver.switchTo().parentFrame(); //switches to immediate parent
        driver.switchTo().defaultContent();// base DOM
        driver.switchTo().frame(0); // to frame id
        driver.switchTo().frame(""); // to frame name
        driver.switchTo().frame(ele); // to frame element

        // screenshot in selenium
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("" + System.currentTimeMillis() + ".png"));

        // taking screenshot of element
        File elementSS = ele.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementSS, new File("./screenshots/" + elementSS.getName() + ".png"));

        // accepting SSL cert error
        ChromeOptions options4 = new ChromeOptions();
        options4.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options4);

        //for internet explorer
        InternetExplorerOptions options1 = new InternetExplorerOptions();
        options1.setAcceptInsecureCerts(true);
        driver = new InternetExplorerDriver(options1);

        // keyboard interactions
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        act.sendKeys(Keys.CONTROL).sendKeys("A").sendKeys(Keys.UP).perform();

        // file upload
        ele.sendKeys("path of the file to be uploaded");

        // setting up custom download path as preferences on options
        ChromeOptions options3 = new ChromeOptions();
        HashMap<String, Object> chromePreferences = new HashMap<>();
        chromePreferences.put("download.default_directory", "/downloads/path");
        chromePreferences.put("download.prompt_for_download", false);
        options3.setExperimentalOption("perfs", chromePreferences);
        driver = new ChromeDriver(options3);

        // Maximize window
        driver.manage().window().maximize();

        // Open Google
        driver.get("https://www.google.com");

        // Print title
        System.out.println("Page Title: " + driver.getTitle());

        // Close browser
        driver.quit();
    }
}
