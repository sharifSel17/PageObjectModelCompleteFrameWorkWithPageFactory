package switchWindow;

import commonApi.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLibrary.SwitchParentWindowToChildWindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sharif on 12/9/2017.
 */
public class TC_002_MultipleWindowHandle extends TestBase {

    SwitchParentWindowToChildWindow switchParentWindowToChildWindow;
    List<String> windowsId = new ArrayList<String>();

    @BeforeClass
    public void setUp()throws IOException{
        init();
    }
    @Test
    public void windowsHandle()throws InterruptedException{
        switchParentWindowToChildWindow = new SwitchParentWindowToChildWindow(driver);
        switchParentWindowToChildWindow.getFacebookLink();

        Iterator<String> itr = getAllWindows();
        while (itr.hasNext()){
            windowsId.add(itr.next());
        }
        driver.switchTo().window(windowsId.get(2));
        boolean status = switchParentWindowToChildWindow.verifyingFacebookPage();
        Thread.sleep(5000);
        driver.switchTo().window(windowsId.get(1));
    }
}
