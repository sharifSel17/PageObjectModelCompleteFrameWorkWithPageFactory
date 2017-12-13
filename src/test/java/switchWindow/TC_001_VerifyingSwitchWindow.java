package switchWindow;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLibrary.SwitchParentWindowToChildWindow;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Sharif on 12/8/2017.
 */
public class TC_001_VerifyingSwitchWindow extends TestBase {

    public static final Logger log = Logger.getLogger(SwitchParentWindowToChildWindow.class.getName());
    SwitchParentWindowToChildWindow switchParentWindowToChildWindow;

    @BeforeClass
    public void setUp()throws IOException{
        init();
    }
    @Test
    public void verifyingSwitchWindow()throws InterruptedException{
        switchParentWindowToChildWindow = new SwitchParentWindowToChildWindow(dr);
        switchParentWindowToChildWindow.getFacebookLink();

        Iterator<String> itr = getAllWindows();

        String parentWindow = itr.next();
        String childWindow = itr.next();

        driver.switchTo().window(childWindow);
        boolean status = switchParentWindowToChildWindow.verifyingFacebookPage();
        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        Assert.assertEquals(true,status);
        log.info("Finished verifying facebook link");


    }
}
