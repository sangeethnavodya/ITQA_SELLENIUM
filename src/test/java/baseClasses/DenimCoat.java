package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DenimCoat {
    WebDriver driver;

    //stores the locators

    By orangeSquare= By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[3]/form/div[5]/div[2]/ul/li[2]/img");

    By denimCoatCard= By.xpath("//*[@id=\"ec_product_image_effect_4381370\"]/a");

    By textColor=By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[3]/form/div[5]/div[2]/div[1]/div");


    public DenimCoat(WebDriver driver){
        this.driver=driver;
    }
    public void clickOrangeSquare(){
        driver.findElement(orangeSquare).click();
    }
    public void clickDenimCoatCard(){
        driver.findElement(denimCoatCard).click();
    }

    public String getTextValue(){
        return  driver.findElement(textColor).getText();
    }

}
