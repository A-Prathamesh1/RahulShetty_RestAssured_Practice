package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/DataTableDemo.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report-json.json",
                "junit:target/cucumber-report-xml.xml"
        },
        tags = "@smoke",
        monochrome = true,
        stepNotifications = true,
        dryRun = false,
        publish = true // automatically crates url to see the report
)
public class DataTableRunner {

}
