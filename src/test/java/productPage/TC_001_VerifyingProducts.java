package productPage;

import commonApi.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLibrary.MenProducts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sharif on 12/7/2017.
 */
public class TC_001_VerifyingProducts extends TestBase {

    public static final Logger log = Logger.getLogger(TC_001_VerifyingProducts.class.getName());
    MenProducts menProducts;

    @BeforeClass
    public void setUp()throws IOException{
        init();
    }

    @Test
    public void verifyingProducts()throws InterruptedException{
        menProducts = new MenProducts(driver);
        log.info("=======Starting verifying Products===============");
        menProducts.clickOnNavigationMenu(MenProducts.mens);
        menProducts.searchButton();
        menProducts.selectProduct(MenProducts.menProduct);
        menProducts.selectCategories(MenProducts.shirts);
        menProducts.selectCategoriesProduct();
        menProducts.selectImg();


    }


}
