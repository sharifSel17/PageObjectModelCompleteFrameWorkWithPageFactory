package homePageTest;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pageLibrary.HomePage;

import java.io.IOException;

/**
 * Created by Sharif on 12/1/2017.
 */
public class TC003_VerifyingLoginDataFromExcelReader extends TestBase {

    public static final Logger log =  Logger.getLogger(TC003_VerifyingLoginDataFromExcelReader.class.getClass());
    HomePage homePage;


    @BeforeClass
    public void setUp()throws IOException{
        init();
        //homePage = new HomePage(driver);
    }

    @DataProvider(name = "login")
    public Object[][] getTestData(){
        Object[][] data = getData("LoginData.xlsx", "LoginTestData");
        return data;
    }


   @Test(dataProvider = "login")
    public void loginFromDifferentRecord(String userName, String userPassword,String runMode)throws InterruptedException{

        if(runMode.equals("N")){
           // throw new SkipException("user marked this record as no run");
        }
        homePage = new HomePage(driver);
        homePage.loginInFromExcelFile(userName, userPassword);
        homePage.clickOnLogout();
        getScreenShot("loginFromDifferentRecord"+userName);
        /*try {
            log.info("=========Starting loginFromDifferentRecord==============");
            homePage.loginInFromExcelFile(userName, userPassword);
            boolean status = homePage.verifyingLogoutIsDisplay();
            if (status) {
                homePage.clickOnLogout();
            }
            Assert.assertEquals(status,true);
            log.info("======Finished loginFromDifferentRecord======");
        }catch (Exception e){
            e.printStackTrace();
        }
       log.info("========Finished verifying to logout is displayed========");*/
    }
}
