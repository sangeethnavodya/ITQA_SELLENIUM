package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.FlamingoTShirt;
import baseClasses.HomePage;
import baseClasses.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

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

    @Test
    public void secondTest(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            HomePage homePage=new HomePage(driver);
            FlamingoTShirt flamingoTShirt=new FlamingoTShirt(driver);
            String priceInHomePage=homePage.flamingoTShirtPriceInHome();
            Thread.sleep(1000);
            homePage.clickFlamingoCard();
            Thread.sleep(1000);
            String priceInFlamingoPage=flamingoTShirt.flamingoTShirtPriceInFlamingoTShirtPage();
            Assert.assertEquals(priceInHomePage,priceInFlamingoPage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    @Test
    public void ThirdTest(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            HomePage homePage=new HomePage(driver);
            DenimCoat denimCoat=new DenimCoat(driver);
            homePage.clickDenimCoatCard();
            Thread.sleep(3000);
            denimCoat.clickOrangeSquare();
            String actualValue=denimCoat.getTextValue();
            String expectedValues="Orange";
            Assert.assertEquals(actualValue,expectedValues);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

}
