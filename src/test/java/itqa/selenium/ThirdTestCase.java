package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdTestCase {
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
