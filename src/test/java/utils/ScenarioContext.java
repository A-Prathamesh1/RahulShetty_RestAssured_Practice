package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private WebDriver driver;
    private Map<String, Object> testData = new HashMap<>();
    private Scenario scenario;

    public ScenarioContext(Scenario scenario) {
        this.scenario = scenario;
    }

    // get set for driver
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    // get set for testdata
    public void setData(String key, String value) {
        testData.put(key, value);
    }

    public Object getData(String key) {
        return testData.get(key);
    }

    // get scenario name
    public String getScenarioName() {
        return this.scenario.getName();
    }

    // log
    public void log(String message) {
        System.out.println(this.scenario.getName() + " : " + message);
    }
}
