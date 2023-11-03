package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.FlamingoTShirt;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClasses.ShoppingCart;

public class TestCases {

    @Test
    public void  firstTest() {
//        System.setProperty("webdriver.chrome.driver", "E:\\S7\\ITQA\\group\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            ShoppingCart shoppingCart=new ShoppingCart(driver);
            shoppingCart.clickAddToCart();
            Thread.sleep(4000);
            shoppingCart.clickCheckOut();
            Thread.sleep(3000);
            float floatValueCartSubTotal =   shoppingCart.getCartSubTotal();
            float floatValueShipping= shoppingCart.getShippingTotal();
            float subTotal=floatValueShipping+floatValueCartSubTotal;
            String expectedTotal = String.format("$%.2f", subTotal);
            String actualTotal=shoppingCart.getGrandTotal();
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
            FlamingoTShirt flamingoTShirt=new FlamingoTShirt(driver);
            String priceInHomePage=flamingoTShirt.flamingoTShirtPriceInHome();
            Thread.sleep(1000);
            flamingoTShirt.clickFlamingoCard();
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
            DenimCoat denimCoat=new DenimCoat(driver);
            denimCoat.clickDenimCoatCard();
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
