package commonApi;


import excelDataReader.ExcelReader;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Sharif on 12/6/2017.
 */
public class TestBase {

    public static final Logger log = Logger.getLogger(TestBase.class.getName());
    public static WebDriver driver;
    ExcelReader excel;

    String url = "http://automationpractice.com/index.php";
    String browser = "chrome";



    public void init()throws IOException {
        selectBrowser(browser);
        getUrl(url);
        String log4jConfigPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
    }

    public void selectBrowser(String browser){
        if(browser.equals("chrome")||browser.equals("CHROME")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")||browser.equals("FIREFOX")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }else if(browser.equals("ie")||browser.equals("IE")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//drivers//chromedriver.exe");
            log.info("Creating the object of "+browser);
            driver = new ChromeDriver();
        }
    }

    public void getUrl(String url){
        log.info("Navigating to "+url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public String[][] getData(String excelName, String sheetName) {
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\excelData\\" + excelName;
        excel = new ExcelReader(path);
        String[][] data = excel.getDataFromSheet(sheetName, excelName);
        return data;
    }

    public void waitForElement(int timeOutInSeconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


        public void getScreenShot(String name) {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

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

    /*public void loadPropertiesFile()throws IOException{
        f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
        FI = new FileInputStream(f);
        Repository.load(FI);
    }*/
}
