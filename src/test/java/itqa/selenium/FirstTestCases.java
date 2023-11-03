package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.FlamingoTShirt;
import baseClasses.HomePage;
import baseClasses.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestCases {

    @Test
    public void  firstTest() {
//        System.setProperty("webdriver.chrome.driver", "E:\\S7\\ITQA\\group\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            HomePage homePage=new HomePage(driver);
            homePage.clickAddToCart();
            Thread.sleep(4000);
            homePage.clickCheckOut();
            Thread.sleep(3000);
            ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
            float floatValueCartSubTotal =   shoppingCartPage.getCartSubTotal();
            float floatValueShipping= shoppingCartPage.getShippingTotal();
            float subTotal=floatValueShipping+floatValueCartSubTotal;
            String expectedTotal = String.format("$%.2f", subTotal);
            String actualTotal=shoppingCartPage.getGrandTotal();
            Assert.assertEquals(actualTotal,expectedTotal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }





}
