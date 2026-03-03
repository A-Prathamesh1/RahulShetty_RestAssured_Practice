package TestRunners;

// when using junit as test runner use @RunWith @CucumberOptions of Junit

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// when using testNG as test runner use @RunWith @CucumberOptions of TestNG
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "stepDefinitions",
        // tags = "@smoke",
        // tags = "@smoke and @regression"
//        tags = "not @skip"
//        tags = "@smoke or @regression",
//        tags = "@smoke and not @regression",
        tags = "(@smoke or @critical) and not @skip",
        monochrome = true,
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-json-report.json"
        }
)
public class CucumberRunner {
    // Running from command line
    // mvn test -Dcucumber.filter.tags="@smoke"
    // mvn test -Dcucumber.filter.tags="@smoke and @critical"
    // mvn test -Dcucumber.filter.tags="@smoke or @regression"
    // mvn test -Dcucumber.filter.tags="not @skip"
    // mvn test -Dcucumber.filter.tags="(@smoke or @critical) and not @slow"
}
