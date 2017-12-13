package customListener;


import commonApi.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sharif on 12/6/2017.
 */
public class Listener extends TestBase implements ITestListener{
    public void onTestStart(ITestResult result) {
        Reporter.log("Test started running:"  + result.getMethod().getMethodName() + " at:" + result.STARTED );
    }

    public void onTestSuccess(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat forMater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        String methodName = result.getName();

        if (result.isSuccess()){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try{
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\";
                File destFile = new File((String) reportDirectory + "\\successScreenShot\\" + methodName + "_" + forMater.format(calendar.getTime()) + ".png");

                FileUtils.copyFile(scrFile, destFile);

                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat forMater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        String methodName = result.getName();

        if (!result.isSuccess()){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try{
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\";
                File destFile = new File((String) reportDirectory + "\\failureScreenShot\\" + methodName + "_" + forMater.format(calendar.getTime()) + ".png");

                FileUtils.copyFile(scrFile, destFile);

                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onFinish(ITestContext arg0) {


    }

    public void onStart(ITestContext arg0) {

    }

}
