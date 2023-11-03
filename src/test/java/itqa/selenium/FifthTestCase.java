package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.HomePage;
import baseClasses.ShoppingCartPage;
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FifthTestCase {
    @Test
    public void FifthTest(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://academybugs.com/find-bugs/");
            driver.manage().window().maximize();
            Thread.sleep(1000);
            HomePage homePage=new HomePage(driver);
            DenimCoat denimCoat=new DenimCoat(driver);
            homePage.clickDenimCoatCard();
            Thread.sleep(3000);
            denimCoat.clickYellowSquare();
            String actualValue=denimCoat.getTextValue();
            String expectedValues="Yellow";
            Assert.assertEquals(actualValue,expectedValues);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
