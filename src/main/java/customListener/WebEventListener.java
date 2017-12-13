package customListener;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

/**
 * Created by Sharif on 12/9/2017.
 */
public class WebEventListener extends TestBase implements WebDriverEventListener {

    public static final Logger log = Logger.getLogger(WebEventListener.class.getName());

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        log("Before Navigate to "+url.toString());
    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        log("After Navigate to "+url.toString());
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        log("before navigate to forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        log("after navigate to back");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log("Trying to get element "+by.toString()+" ");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log("Found element by "+by.toString()+"");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        log("clicked on"+webElement.toString()+"");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        log("Clicked on "+webElement.toString()+" ");

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        log("value of the "+webElement.toString()+" before changed");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        log("value of the "+webElement.toString()+" after changed");
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable error, WebDriver webDriver) {
        log("Exception Occur"+error+"");
    }

}
