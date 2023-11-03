package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    //stores the locators

    By addToCart= By.xpath("//*[@id=\"ec_add_to_cart_5\"]");
    By checkOut = By.xpath("//*[@id=\"ec_added_to_cart_5\"]");

    By flamingoTShirtPrice= By.xpath("//*[@id=\"ec_product_image_4881370\"]/div[3]/div[1]/span");

    By flamingoTShirtCard=By.xpath("//*[@id=\"ec_product_image_effect_4881370\"]/a");

    By denimCoatCard= By.xpath("//*[@id=\"ec_product_image_effect_4381370\"]/a");

    By blueHoodie=By.xpath("//*[@id=\"ec_product_image_effect_3381370\"]/a");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }
    public void clickCheckOut(){
        driver.findElement(checkOut).click();
    }

    public void clickFlamingoCard(){
        driver.findElement(flamingoTShirtCard).click();
    }
    public String flamingoTShirtPriceInHome(){
        return driver.findElement(flamingoTShirtPrice).getText();
    }

    public void clickDenimCoatCard(){
        driver.findElement(denimCoatCard).click();
    }

    public void clickBlueHoodie(){
        driver.findElement(blueHoodie).click();
    }

}
