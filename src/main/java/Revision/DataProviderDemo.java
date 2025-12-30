package Revision;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @DataProvider(name = "credProvider", parallel = true)
    public Object[][] getCreds() {
        return new Object[][]{
                {"uname1", "pass1"},
                {"uname2", "pass2"}
        };
    }

    @Test(dataProvider = "credProvider")
    public void loginTest(String uname, String pass) {
        System.out.println(uname + " : " + pass);
    }
}
