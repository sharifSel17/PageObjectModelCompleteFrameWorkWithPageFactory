package pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Sharif on 12/6/2017.
 */
public class HomePage {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(HomePage.class.getName());

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;

    @FindBy(xpath = ".//*[@id='email']")
    WebElement LoginEmailId;

    @FindBy(xpath = ".//*[@id='passwd']")
    WebElement LoginPassword;

    @FindBy(xpath = ".//*[@id='SubmitLogin']")
    WebElement submitButton;

    @FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
    WebElement AuthenticationFailed;

    @FindBy(xpath = ".//*[@id='email_create']")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id='SubmitCreate']")
    WebElement ClickEmailButton;

    @FindBy(xpath = ".//*[@id='id_gender1']")
    WebElement mrRadioButton;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='customer_lastname']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//*[@id='days']")
    WebElement dayForDOB;

    @FindBy(xpath = "//*[@id='months']")
    WebElement monthForDOB;

    @FindBy(xpath = "//*[@id='years']")
    WebElement yearForDOB;

    @FindBy(xpath = "//*[@id='firstname']")
    WebElement firstNameForAddress;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement lastNameForAddress;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement address;

    @FindBy(xpath = "//*[@id='city']")
    WebElement city;

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement zipCode;

    @FindBy(xpath = "//*[@id='id_state']")
    WebElement state;

    @FindBy(xpath = "//*[@id='id_country']")
    WebElement country;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement mobile;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement referenceEmailAddress;


    @FindBy(xpath = ".//*[@id='SubmitCreate']/span")
    WebElement clickOnRegistration;

    @FindBy(xpath = ".//*[@id='submitAccount']")
    WebElement clickOnFinalRegistration;

    @FindBy(xpath = ".//*[@id='center_column']/p")
    WebElement successMessage;

    @FindBy(xpath = ".//*[@id='center_column']/div/p")
    WebElement failureMessageRecord;

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    WebElement signOut;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void selectDays(String day){
        dayForDOB.click();
        //./*//*[@id='days']/option[10]
        String day1 ="//*[@id='days']/option[";
        String day2 ="]";
        driver.findElement(By.xpath(day1+day+day2)).click();
    }
    public void selectMonth(String month){
        monthForDOB.click();
        List<WebElement> monthsData = driver.findElements(By.xpath(".//*[@id='months']/option"));
        for (WebElement mon: monthsData) {
            if(mon.getText().trim().toLowerCase().equals(month.toLowerCase())){
                mon.click();
            }
        }
    }

    public void selectYears(String year){
        yearForDOB.click();
        List<WebElement> yearsData = driver.findElements(By.xpath(".//*[@id='years']/option"));
        for (WebElement yr: yearsData) {
            if (yr.getText().trim().equals(year)){
                yr.click();
            }
        }
    }

    public void selectState(String selectStateName){
        state.click();
        List<WebElement> statesData = driver.findElements(By.xpath(".//*[@id='id_state']/option"));
        for (WebElement stateList: statesData) {
            if(stateList.getText().trim().toLowerCase().equals(selectStateName.toLowerCase())){
                stateList.click();
            }
        }
    }

    public void loginToApplication(String email, String password)throws InterruptedException{
        signIn.click();
        log.info("Clicked on sign in and object is :-"+signIn.toString());
        LoginEmailId.sendKeys(email);
        log.info("Entered email address:-"+email+" and object is :-"+LoginEmailId.toString());
        LoginPassword.sendKeys(password);
        log.info("Entered password:-"+password+" and object is:-"+LoginPassword.toString());
        submitButton.click();
        log.info("Elicked on submit button and object is:-"+submitButton.toString());
    }

    public String invalidText(){
        log.info("Error message is:-"+AuthenticationFailed.getText());
        return AuthenticationFailed.getText();
    }

    public void clickOnRegisterEmailButton(String email)throws InterruptedException{
        signIn.click();
        Thread.sleep(5000);
        log.info("Click in sign button :-"+signIn.toString());
        emailAddress.sendKeys(email);
        log.info("Select email id and object is :-"+emailAddress.toString());
        clickOnRegistration.click();
        Thread.sleep(5000);
        log.info("Click in registration button and object is :-"+clickOnRegistration.toString());
    }

    public void loginInFromExcelFile(String email, String pass)throws InterruptedException{
        signIn.click();
        Thread.sleep(5000);
        LoginEmailId.sendKeys(email);
        LoginPassword.sendKeys(pass);
        submitButton.click();
    }

    public void newUserRegistration(String userFirstName,String userLastName,String userPassword,String day, String month, String year,String userFirstNameForAddress,String userLastNameForAddress,String userAddress,String userCity,String userZipCode,String userMobile,String userReferenceAddress){
        mrRadioButton.click();
        log.info("Click in mr RadioButton button :-"+mrRadioButton.toString());
        firstName.sendKeys(userFirstName);
        log.info("Select first name is :-"+firstName.toString());
        lastName.sendKeys(userLastName);
        log.info("Select last name is :-"+lastName.toString());
        password.sendKeys(userPassword);
        log.info("Select  password is :-"+password.toString());
        selectDays(day);
        log.info("Selected  day is :-"+day.toString());
        selectMonth(month);
        log.info("Select  month is :-"+month.toString());
        selectYears(year);
        log.info("Select  year is :-"+year.toString());
        firstNameForAddress.sendKeys(userFirstNameForAddress);
        log.info("Select first name for address is :-"+firstNameForAddress.toString());
        lastNameForAddress.sendKeys(userLastNameForAddress);
        log.info("Select last name for address is :-"+signIn.toString());
        address.sendKeys(userAddress);
        log.info("Select address in sign button :-"+address.toString());
        city.sendKeys(userCity);
        log.info("Select city name is :-"+city.toString());
        selectState("New York");
        log.info("Select state name is :-"+state.toString());
        zipCode.sendKeys(userZipCode);
        log.info("Select zip code is :-"+zipCode.toString());
        country.click();
        log.info("Select country name is :-"+country.toString());
        mobile.sendKeys(userMobile);
        log.info("Select mobile number is :-"+mobile.toString());
        referenceEmailAddress.sendKeys(userReferenceAddress);
        log.info("select reference is :-"+referenceEmailAddress.toString());
        clickOnFinalRegistration.click();
        log.info("Click in final registration button :-"+clickOnFinalRegistration.toString());
    }

    public String getRegistrationSuccessMessage(){
        log.info("=====Registration Success Message======");
        log.info("Success Message is :-"+successMessage.getText());
        return successMessage.getText();
    }

    public String failureMessage(){
        log.info("======Registration failure message=========");
        log.info("Failure Message is:-"+failureMessageRecord.getText());
        return failureMessageRecord.getText();
    }

   /* public boolean verifyingLogoutIsDisplay(){
        try{
            waitForElement(5000,signOut);
            signOut.isDisplayed();
            log.info("Clicked on sign in button :-"+signOut.toString());
            return true;
        }catch (Exception e){
           return false;
        }
    }*/

    public void clickOnLogout(){
        signOut.click();
    }


}
