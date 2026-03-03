package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.datatable.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import pojo.User;
public class DataTableStepDefinitions {
    List<Map<String, String>> listOfUsers;
    List<String> listOfBrowsers;

    @Given("following users exists:")
    public void following_users_exists(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        listOfUsers = dataTable.asMaps();
        for (Map<String, String> m : listOfUsers) {
            System.out.println(m.get("name") + " " +
                    m.get("email") + " " + m.get("role"));
        }
    }

    @When("sys processes users")
    public void sys_processes_users() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("total users should be {int}")
    public void total_users_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals((long) listOfUsers.size(), (long) int1);
    }

    @Given("browser list contains:")
    public void browser_list_contains(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        listOfBrowsers = dataTable.asList();
        System.out.println("browsers: " + listOfBrowsers);
    }

    // just to demo use of raw list
    List<List<String>> userDetailsLines;

    @Given("user data")
    public void listOfUsersAsRawData(DataTable dataTable) {
        userDetailsLines = dataTable.asLists();
        for (int i = 0; i < userDetailsLines.size(); i++) {
            List<String> detailsOfUser = userDetailsLines.get(i);
            System.out.println("row: " + i + ":" + detailsOfUser);
        }
    }

    // dataTables to custom objects
    @Given("data tables to User object")
    public void oCustomObject(DataTable dataTable) {
        List<User> users = dataTable.asList(User.class);
        for (User user : users) {
            System.out.println("User" + user + ",");
        }
    }
}
