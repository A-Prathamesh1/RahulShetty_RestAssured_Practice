package Listeners;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.junit.jupiter.api.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import what_is_op.ExpectedException;

public class TestNG_And_Junit {

    @Test
    public void testNGTest() {
        System.out.println("testNG test");
    }

    @org.junit.jupiter.api.Test
    public void junitTest() {
        System.out.println("Junit test");
    }

    @BeforeClass
    public void testNGTest1() {
        System.out.println("Beforeclass testng test annotation");
    }

    @AfterClass
    public void testNGTest2() {
        System.out.println("testng afterclass annot");
    }

    @BeforeEach
    public void JunitTest2() {
        System.out.println("before each junit test");
    }

    @AfterEach
    public void junitTest3() {
        System.out.println("Junit after each");
    }

    // data provider annotations for test nG & junit
    @DataProvider
    public void testNGDP() {
        System.out.println("TestNG DP");
    }

    @ParameterizedTest
    public void parameterizsedTest() {

    }

    // various attributes on testNG @Test()
    @Test(invocationCount = 1)
    public void testAttrib() {
        System.out.println("number of times this test method must invoke");
    }

    @Test(timeOut = 10)
    public void timeOutTest() {
        System.out.println("maximum millisec this test method must take before failuer");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void expectedExceptionTest() {
        System.out.println("this method will pass if it throws the expected exception ");
        throw new IllegalArgumentException();
    }

    @Test(alwaysRun = true)
    public void alwaysRunTest() {
        System.out.println("always  runs the test method even if test it depends on fails");
    }

    @Test(dependsOnMethods = "alwaysRunTest")
    public void dependsOnMethods() {

    }

    @Test(priority = 1)
    public void priorityMethod() {
        System.out.println("prio rity of methjod");
    }

    // Testng assertions
    @Test(description = "testNG assertions")
    public void testNGAssertions() {
        int actual = 10;
        int expected = 100;
        Assert.assertEquals(actual, expected, "must be 10");
        Assert.assertNotEquals(actual, expected, "must be not be equal");

        Assert.assertTrue(actual == 10, "must be 10");
        Assert.assertFalse(actual != 100, "must be 100");

        Assert.assertNull(actual, "must be null");
        Assert.assertNotNull(actual, "must not be null");

        Assert.assertSame(actual, 10, "must be same");
        Assert.assertNotSame(actual, 100, "must not be same");

        Assert.fail("deliberately fail the test");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected, "should be equal");
        // will continue even if above assertion fails
        softAssert.assertTrue(actual == 10, "should be true");
        // .
        // .
        // .
        softAssert.assertAll(); // report all the failure

    }

    @DataProvider(name = "loginTestData")
    public Object[][] getLoginTestData() {
        return new Object[][]{
                {"u1", "p1", true},
                {"u2", "p2", true},
                {"", "", false},
                {"u3", "wring_pass", false}
        };
    }

    @org.testng.annotations.Test(dataProvider = "loginTestData")
    public void loginTEst(String uname, String pass, boolean expected) {
        boolean actual = true;//performLogin(uname, pass);
        Assert.assertEquals(actual, expected, "failed to login");
    }

    // receive parameters from Run_Tests_parallel_testng.xml
    @Parameters({"browser", "baseURL"})
    public void testParameters(String browser, String baseURL) {
        System.out.println(baseURL + ": " + browser);
    }

    // | Feature                  | TestNG                                              | JUnit (JUnit 5)                                      |
    // |———————————————————————|——————————————————————————————————————|————————————————————————————————————————|
    // | Full Form                | Test Next Generation                               | Java Unit Testing Framework                         |
    // | Annotations              | @Test, @BeforeMethod, @AfterMethod, @DataProvider | @Test, @BeforeEach, @AfterEach, @ParameterizedTest  |
    // | Test Configuration       | XML based (Run_Tests_parallel_testng.xml)                             | No XML required (annotation + extension based)      |
    // | Suite Execution          | Yes (via Run_Tests_parallel_testng.xml)                               | Limited (via build tool or @Suite)                  |
    // | Parameterized Tests      | @DataProvider                                      | @ParameterizedTest (@ValueSource, etc.)             |
    // | Parallel Execution       | Built-in support (methods/classes/tests)           | Supported via JUnit Platform + build config         |
    // | Grouping Tests           | Yes (@Test(groups="smoke"))                        | Tags (@Tag)                                         |
    // | Dependency Between Tests | Yes (dependsOnMethods / dependsOnGroups)           | Not supported natively                              |
    // | Test Priority            | Yes (priority attribute)                           | Not supported                                       |
    // | Default Execution Order  | Based on priority / XML order                      | Determined by method order (not guaranteed)         |
    // | Assertions               | org.testng.Assert                                  | org.junit.jupiter.api.Assertions                    |
    // | Reporting                | Built-in HTML reports                              | Basic reporting (depends on build tool)             |
    // | Thread-Safety Focus      | Designed for integration testing                   | Primarily unit testing                              |
    // | Integration With Selenium| Very Popular in automation frameworks              | Also supported but less flexible than TestNG       |
    // | Use Case                 | Automation frameworks, regression suites           | Unit testing, TDD, modern microservices testing     |

}
