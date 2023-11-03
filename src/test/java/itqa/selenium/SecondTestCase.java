package itqa.selenium;

import baseClasses.FlamingoTShirt;
import baseClasses.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {
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
}
