package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println(suite.getName() + " started");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(suite.getName() + " suite execution finished");

        System.out.println(suite.getAllInvokedMethods().size() + " methods run");
    }

}
