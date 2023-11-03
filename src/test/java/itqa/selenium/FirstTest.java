package itqa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import shoppingCart.ShoppingCart;

public class FirstTest {

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
            Assert.assertEquals(expectedTotal,actualTotal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

}
