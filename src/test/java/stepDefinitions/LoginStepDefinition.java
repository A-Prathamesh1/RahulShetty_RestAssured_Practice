package stepDefinitions;

import coding_basics.OOP.multipleInheritance.C;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import utils.ScenarioContext;

public class LoginStepDefinition {
    ScenarioContext context;

    public LoginStepDefinition(ScenarioContext context) {
        this.context = context;
    }

    @Given("User must be on login page")
    public void user_must_be_on_login_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriver driver = new ChromeDriver();
        context.setDriver(driver);
        context.log("Driver set browser init");

        String env = "stage";
        if (env.equals("prod")) {
            throw new SkipException("skip this test in prod env");
        }
    }

    @Given("User enters valid username {string}")
    public void user_enters_valid_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User enters valid password {string}")
    public void user_enters_valid_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should should see the dashboard")
    public void user_should_should_see_the_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should see the {string} message")
    public void user_should_see_the_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enters invalid username {string}")
    public void when_user_enters_invalid_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enters invalid password {string}")
    public void when_user_enters_invalid_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click login button")
    public void user_click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should not be logged in")
    public void user_should_not_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should see {string} error message")
    public void user_should_see_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enter uname1")
    public void when_user_enter_uname1() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("when user enter pass1")
    public void when_user_enter_pass1() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user user should see welcome")
    public void user_user_should_see_welcome() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enter uname2")
    public void when_user_enter_uname2() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enter pass2")
    public void when_user_enter_pass2() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user user should see invalid cred")
    public void user_user_should_see_invalid_cred() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enter uname3")
    public void when_user_enter_uname3() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("when user enter ")
    public void when_user_enter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user user should see error")
    public void user_user_should_see_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
