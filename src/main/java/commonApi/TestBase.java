package commonApi;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import customListener.WebEventListener;
import excelDataReader.ExcelReader;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


/**
 * Created by Sharif on 12/6/2017.
 */
public class TestBase {

    public final Logger log = Logger.getLogger(TestBase.class.getName());
    public WebDriver dr;
    public EventFiringWebDriver driver;
    public WebEventListener eventListener;
    public static ExtentReports extent;
    public static ExtentTest test;
    ExcelReader excel;
    Properties OR;

    /*String url = "https://www.amazon.com/";
    String browser = "chrome";
*/
    static{
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        extent = new ExtentReports(System.getProperty("user.dir")+"//src//main//java//extentReport//report_"+formater.format(calendar.getTime())+".html",false);

    }

    public void loadProperties()throws IOException{
        OR = new Properties();
        File file = new File(System.getProperty("user.dir")+"//src//main//java//config//config.properties");
        FileInputStream f = new FileInputStream(file);
        OR.load(f);
    }

    public void init()throws IOException {
        loadProperties();
        selectBrowser(OR.getProperty("browser"));
        getUrl(OR.getProperty("url"));
        String log4jConfigPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void selectBrowser(String browser){
        if(browser.equals("chrome")||browser.equals("CHROME")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            dr = new ChromeDriver();
            driver=new EventFiringWebDriver(dr);
            eventListener= new WebEventListener();
            //driver.register(eventListener);
        }else if (browser.equals("firefox")||browser.equals("FIREFOX")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            dr = new ChromeDriver();
            dr = new ChromeDriver();
            driver=new EventFiringWebDriver(dr);
            eventListener= new WebEventListener();
            //driver.register(eventListener);
        }else if(browser.equals("ie")||browser.equals("IE")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            dr = new ChromeDriver();
            dr = new ChromeDriver();
            driver=new EventFiringWebDriver(dr);
            eventListener= new WebEventListener();
            //driver.register(eventListener);
        }
    }

    public void getUrl(String url){
        log.info("Navigating to "+url);
        dr.get(url);
        dr.manage().window().maximize();
    }

    public String[][] getData(String excelName, String sheetName) {
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\excelData\\" + excelName;
        excel = new ExcelReader(path);
        String[][] data = excel.getDataFromSheet(sheetName, excelName);
        return data;
    }

    public void waitForElement(int timeOutInSeconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(dr,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


        public void getScreenShot(String name) {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);

            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\screenshot\\";
                File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                // This will help us to link the screen shot in testNG report
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='\\" + destFile.getAbsolutePath() + "' height='200' width='200'/></a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Iterator<String> getAllWindows(){
            Set<String> window = dr.getWindowHandles();
            Iterator<String> itr = window.iterator();
            return itr;
        }

    public String captureScreen(String fileName) {
        if (fileName == "") {
            fileName = "reports";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\src\\main\\java\\failureScreenShot\\";
            destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            // This will help us to link the screen shot in testNG report
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }
        public void log(String data){
            log.info(data);
            Reporter.log(data);
        }

    public void getresult(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, result.getName() + " test is pass");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
            String screen = captureScreen("");
            test.log(LogStatus.FAIL, test.addScreenCapture(screen));
        } else if (result.getStatus() == ITestResult.STARTED) {
            test.log(LogStatus.INFO, result.getName() + " test is started");
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        getresult(result);
    }
    @BeforeMethod
    public void beforeMethod(Method result) {
        test = extent.startTest(result.getName());
        test.log(LogStatus.INFO, result.getName() + " test Started");
    }
    @AfterClass(alwaysRun = true)
    public void endTest() {
        closeBrowser();
    }

    public void closeBrowser(){
        driver.quit();
        log.info("browser closed");
        extent.endTest(test);
        extent.flush();
    }
}
