package itqa.selenium;

import baseClasses.DenimCoat;
import baseClasses.HomePage;
import baseClasses.ShoppingCartPage;
import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
            String text = driver.findElement(By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[1]/h1")).getText();

            // Detect language
            String language = null;
            try {
                Detector detector = DetectorFactory.create();
                detector.append(text);
                language=detector.detect();
            } catch (LangDetectException e) {
                e.printStackTrace();
            }
            // Check if the language is English
            Assert.assertEquals(language, "en", "The text is not in English.");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
