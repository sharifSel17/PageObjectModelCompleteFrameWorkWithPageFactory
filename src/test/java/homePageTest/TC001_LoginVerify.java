package homePageTest;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageLibrary.HomePage;

import java.io.IOException;

/**
 * Created by Sharif on 12/6/2017.
 */
public class TC001_LoginVerify extends TestBase{
    public static final Logger log = Logger.getLogger(TC001_LoginVerify.class.getName());
    HomePage homePage;

   @BeforeClass
    public void setUp()throws IOException {
        init();
    }


   @Test
    public void loginToCredential()throws InterruptedException{
        log("=======Etarting verifying credentials test=========");
        homePage = new HomePage(driver);
        homePage.loginToApplication("admin123456@gmail.com","admin123");

       //Assert.assertEquals(true,homePage.failureMessage());
        //getScreenShot("loginToCredential");
        //Assert.assertEquals(homePage.invalidText(),"Authentication failed.");
        log("==========Finished verifying credential test============");
    }
}
