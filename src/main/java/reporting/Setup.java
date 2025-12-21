package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportManager.createInstance(fullPath, "Test API Automation Report", "Test Execution Report");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        ExtentTest test = extentReports.createTest("Test Name: " +
                testResult.getTestClass().getName() + " - " +
                testResult.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetail(result.getThrowable().getMessage());

        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replace(",", "<br>");
        String formattedStackTrace = "<details>\n" +
                "    <summary>Click Here to See Exception Logs</summary>\n" +
                "    "+ stackTrace +"\n" +
                "</details>\n";

        ExtentReportManager.logExceptionDetail(formattedStackTrace);
    }
}