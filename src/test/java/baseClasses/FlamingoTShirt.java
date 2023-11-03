package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlamingoTShirt {

    WebDriver driver;

    //stores the locators

    By flamingoTShirtPrice= By.xpath("//*[@id=\"ec_product_image_4881370\"]/div[3]/div[1]/span");

    By flamingoTShirtCard=By.xpath("//*[@id=\"ec_product_image_effect_4881370\"]/a");

    By priceInFlamingoTShirtPagePrice=By.xpath("//*[@id=\"post-5547\"]/div/section/div[1]/div[3]/form/div[2]/span");

    public FlamingoTShirt(WebDriver driver){
        this.driver=driver;
    }
    public void clickFlamingoCard(){
        driver.findElement(flamingoTShirtCard).click();
    }
    public String flamingoTShirtPriceInHome(){
        return driver.findElement(flamingoTShirtPrice).getText();
    }
    public String flamingoTShirtPriceInFlamingoTShirtPage(){
        return driver.findElement(priceInFlamingoTShirtPagePrice).getText();
    }





}
