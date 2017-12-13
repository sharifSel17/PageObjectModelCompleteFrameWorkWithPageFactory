package pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sharif on 12/8/2017.
 */
public class SwitchParentWindowToChildWindow {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(SwitchParentWindowToChildWindow.class.getName());

    @FindBy(xpath = ".//*[@id='social_block']/ul/li[1]/a")
    WebElement facebookLink;

    @FindBy(xpath = "//*[contains(text(),'You must log in to continue.')]")
    WebElement facebookVerifyingMessage;

    public SwitchParentWindowToChildWindow(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void getFacebookLink(){
        facebookLink.click();
        log.info("clicked on facebook link and object is :"+facebookLink.toString());
    }

    public boolean verifyingFacebookPage(){
        try{
            facebookVerifyingMessage.isDisplayed();
        return true;
        }catch (Exception e){
            return false;
        }
    }
}
