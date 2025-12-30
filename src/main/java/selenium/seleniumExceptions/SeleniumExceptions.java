package selenium.seleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class SeleniumExceptions {
    public static void main(String[] args) {
        /*
         * NoSuchElementException : explicit wait
         * */
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

        /*
         * StaleElementReferenceException : Element was found but no longer available in the DOM.
         * solun: refresh the page, wait until element is visible
         * */
        WebElement buttonEle = driver.findElement(By.id("button"));
        buttonEle.click(); // element vanishes from DOM

        driver.navigate().refresh();
        // relocate
        WebElement buttonEle1 = driver.findElement(By.id("button"));
        buttonEle1.click();

        // OR explicitly wait for the element
        WebDriverWait waitForButton = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        WebElement buttonElem = waitForButton.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))));
        buttonElem.click();

        /*
         * ElementNotInteractableException: element is there in the DOM, but it's not interactable, covered, disabled.
         * wait for element to be clickable i.e. interactable
         * */
        WebElement ButtonEle = driver.findElement(By.id(""));
        WebDriverWait waitForButton1 = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        ButtonEle = waitForButton1.until(ExpectedConditions.elementToBeClickable(By.id("")));
        ButtonEle.click();

        // OR scroll the element into view to make it clickable
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("argument[0].scrollIntoView(true)", buttonElem);

        /*
         *TimeoutException: when time in the wait is over and condition is failed within that time
         * solun: increase the timer, wait for somemore time OR write better locator
         * */

        /**
         * NoSuchWindowException :  when tried to switch to wrong window handle
         */
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle + 12); // wrong window handle will throw NoSuchWindowException

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        /**
         *
         * NoSuchFrameException: When trying to switch to frame that doesn't exist.
         * wait until frameToBeAvailableAndSwitchToIt()
         * */
        WebDriverWait frameWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        frameWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));

        /**
         * ElementClickInterceptedException: when element is covered with another element and not able to receive the click
         *
         * // javascript click
         * // scrollIntoView()
         * // wait for invisibility of covered element
         * // wait to be clickable
         * */

        WebElement ele = driver.findElement(By.id(""));
        ele.click();// not able to click, ElementClickInterceptedException thrown

        /**
         * javascript click to the element
         * */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click()", ele);

        /**
         * scrollIntoView()
         * */
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView(true)", ele);
        // rest of the actions

        /**
         * wait for element to be Clickable
         * */
        WebDriverWait waitForEle = new WebDriverWait(driver, Duration.ofSeconds(10));
        ele = waitForEle.until(ExpectedConditions.elementToBeClickable(By.id("")));
        ele.click();

        /**
         * wait for invisibility of elem
         * */
        WebElement elem = driver.findElement(By.id(""));
        WebDriverWait waitFor = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitFor.until(ExpectedConditions.invisibilityOf(elem));

        /**
         * Invalid selector exception
         * */
        WebElement element = driver.findElement(By.id(""));
        // InvalidSelectorException
        // solution: check the selector in the dev tools
        // check locator syntax

        /**
         * NoAlertPresentException
         * */
        driver.switchTo().alert(); // NoAlertPresentException
        WebDriverWait waitForAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForAlert.until(ExpectedConditions.alertIsPresent());
        // again switch to alert and accept or reject

        /**
         * SessionNotFoundException: when driver related methods are invoked after driver is quit
         * solution: Do not use the driver after quiting
         * reinitialize the driver
         * */

        /**
         * WebDriverException: when webdriver and browser version does not match
         * compatible or latest browser & webdriver must be used
         * */

        /**
         * JavascriptException: when there is problem with javascript, maybe syntax error
         * */

        /**
         * MoveTargetOutOfBoundsException: when selenium tries to move an element to element which is not in viewport as
         * of now;
         * */

        WebElement element1 = driver.findElement(By.id(""));
        Actions action = new Actions(driver);
        action.moveToElement(element1).click().perform(); // MoveTargetOutOfBoundException, since element1 is not in viewport

        // bring the element1 into viewport
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("argument[0].scrollIntoView(true);", element1);
    }
}
