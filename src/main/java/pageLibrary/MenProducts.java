package pageLibrary;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sharif on 12/7/2017.
 */
public class MenProducts extends TestBase {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(MenProducts.class.getName());

    public static final String mens = "Men";
    public static final String menProduct = "Clothing";
    public static final String shirts = "Shirts";
    public static final String polo = "";

    /*@FindBy(xpath = "./*//*[@id='leftNav']/ul/ul/li/span/ul/div/li/span/a/span")
    List<WebElement> womenProduct;*/

    public MenProducts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnNavigationMenu(String menCloth) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='searchDropdownBox']/option[contains(text(),'" + menCloth + "')]")).click();
        log.info(menCloth + " Navigation has been selected");
    }

    public void selectProduct(String product) {
        driver.findElement(By.xpath(".//*[@id='leftNav']/ul/ul/li/span/ul/div/li/span/a/span[contains(text(),'" + product + "')]")).click();
        log.info(product + " Navigation has been selected");
    }

    public void selectCategories(String categories){
        driver.findElement(By.xpath(".//*[@id='leftNav']/ul/ul/li/span/ul/div/li/span/ul/div/li/span/a/span[contains(text(),'"+categories+"')]")).click();
        log.info(categories+" navigation has been clicked ");
    }

    public void selectCategoriesProduct()throws InterruptedException{
        Thread.sleep(9000);
        driver.findElement(By.xpath(".//*[@id='leftNav']/ul[2]/ul/li/span/ul/div/li[2]/span/ul/div/li[12]/span/a/span")).click();
        log.info("Pants navigation has been clicked ");
    }

    public void selectImg(){
        driver.findElement(By.xpath(".//*[@id='anonCarousel1']/ol/li[1]/a/img")).click();
        log.info("Image navigation has been clicked ");
    }
    public void searchButton() {
        driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();

    }




































   /* public void getAllText() {
    List<WebElement> listOfText = driver.findElements(By.xpath("./*//*[@id='leftNav']/ul/ul/li/span/ul/div/li/span/a/span"));
        for(int i = 0;i<listOfText.size();i++)
        {
          String optionName = listOfText.get(i).getText();
          System.out.println(optionName);
        }
    }

    public void selectState(String selectStateName){
        List<WebElement> statesData = driver.findElements(By.xpath("/*//*[@id='leftNav']/ul/ul/li/span/ul/div/li/span/a/span"));
        for (WebElement stateList: statesData) {
            if(stateList.getText().trim().toLowerCase().equals(selectStateName.toLowerCase())){
                stateList.click();
            }
        }
    }*/

    public void expandOnTops(){

    }



    //.//*[@id='categories_block_left']/div/ul/li[1]/span

    /*public List<WebElement> selectProduct(){
        List<WebElement> list = womenProduct;
        return list;
    }
*/

}
