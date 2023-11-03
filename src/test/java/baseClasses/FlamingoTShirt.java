package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlamingoTShirt {

    WebDriver driver;

    //stores the locators


    By priceInFlamingoTShirtPagePrice=By.xpath("//*[@id=\"post-5547\"]/div/section/div[1]/div[3]/form/div[2]/span");

    public FlamingoTShirt(WebDriver driver){
        this.driver=driver;
    }
    public String flamingoTShirtPriceInFlamingoTShirtPage(){
        return driver.findElement(priceInFlamingoTShirtPagePrice).getText();
    }





}
