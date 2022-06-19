package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class Listeners extends CommonOps implements ITestListener {

    @Attachment(value = "Page ScreenShot", type = "Image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void onStart(ITestContext execution) {
        System.out.println("------------ Starting Execution ------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("------------ Execution Ended ------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("------------ Skipping Test: " + test.getName() + " ------------");

    }

    public void onTestStart(ITestResult test) {
        System.out.println("------------ Starting Test: " + test.getName() + " ------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("------------ Test: " + test.getName() + " Passed ------------");
        if (!getData("PlatformName").equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Delete recorded File
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete()) //  file.delete() -> delete the file , if (file.delete()) -> check if file deleted
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to Delete File");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("------------ Test " + test.getName() + " Failed ------------");
        if (!getData("PlatformName").equalsIgnoreCase("api")) {
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }
}
