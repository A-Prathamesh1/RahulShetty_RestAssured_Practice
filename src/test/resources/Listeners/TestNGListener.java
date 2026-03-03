package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + " finished");
        System.out.println(context.getAllTestMethods().length + " total tests");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " succeeded");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " failed");
        takeScreenShot(result.getName());
    }

    public void takeScreenShot(String testName) {
        System.out.println(testName + " ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " skipped");
    }

}
