package homePageTest;

import commonApi.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLibrary.HomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by Sharif on 11/30/2017.
 */
public class TC002_NewUserRegistrationToApplication extends TestBase {

    public static final Logger log = Logger.getLogger(TC002_NewUserRegistrationToApplication.class.getName());
    HomePage homePage;
    String dynamicCreateEmailAddress = "admin"+System.currentTimeMillis()+"@gmail.com";
    String fName = "Jhon";
    String lName = "Adam";
    String uPassword = "admin123";
    String selectDay = "10";
    String selectMonth = "January";
    String selectYear = "2017";
    String fNameForAddress = "Jhon";
    String lNameForAddress = "Kery";
    String uAddress = "344 Navy Street";
    String uCity = "Brooklyn";
    String uState = "NY";
    String uZip = "11220";
    String uMobile = "3478903456";
    String uReferenceAddress = "344 Navy Street";



    @BeforeMethod
    public void setUp()throws IOException{
        init();
    }
    @Test
    public void userRegistrationProcessGetToAccessInApplication()throws InterruptedException{
        log.info("============Started to get registration as a new user============");
        homePage = new HomePage(driver);
        homePage.clickOnRegisterEmailButton(dynamicCreateEmailAddress);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        homePage.newUserRegistration(fName,lName,uPassword,selectDay,selectMonth,selectYear,fNameForAddress,lNameForAddress,uCity,uState,uZip,uMobile,uReferenceAddress);
        //Assert.assertEquals(homePage.getRegistrationSuccessMessage(),"Welcome to your account. Here you can manage all of your personal information and orders.");
        //Assert.assertEquals(homePage.failureMessage(),"There are 1 errors");
        Thread.sleep(2000);
        homePage.clickOnLogout();
        Thread.sleep(2000);
        log.info("=============End Test===============");
    }
    @AfterClass
    public void endTest(){
        driver.quit();
    }

}
