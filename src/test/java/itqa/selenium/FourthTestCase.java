package itqa.selenium;

import baseClasses.BlueHoodiePage;
import baseClasses.DenimCoat;
import baseClasses.HomePage;
import baseClasses.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FourthTestCase {
    @Test
    public void FourthTest(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            HomePage homePage=new HomePage(driver);
            BlueHoodiePage blueHoodiePage=new BlueHoodiePage(driver);
            ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
            homePage.clickBlueHoodie();
            Thread.sleep(2000);
            blueHoodiePage.clickPlusButton();
            Thread.sleep(2000);
            float blueHoodieActualPrice=blueHoodiePage.blueHoodiePrice();
            blueHoodiePage.clickAddToCart();
            Thread.sleep(4000);
            float blueHoodieExpectedPrice=shoppingCartPage.getCartSubTotal();
            Assert.assertEquals(blueHoodieActualPrice*2,blueHoodieExpectedPrice);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
