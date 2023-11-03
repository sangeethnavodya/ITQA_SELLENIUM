package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DenimCoat {
    WebDriver driver;

    //stores the locators

    By orangeSquare= By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[3]/form/div[5]/div[2]/ul/li[2]/img");

    By yellowSquare=By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[3]/form/div[5]/div[2]/ul/li[5]/img");

    By textColor=By.xpath("//*[@id=\"post-6192\"]/div/section/div[1]/div[3]/form/div[5]/div[2]/div[1]/div");

    By DenimWebSite=By.xpath("//*[@id=\"manufacturer-bug\"]/a");


    public DenimCoat(WebDriver driver){
        this.driver=driver;
    }
    public void clickOrangeSquare(){
        try {
            driver.findElement(orangeSquare).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void clickYellowSquare(){
        try {
            driver.findElement(yellowSquare).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void clickWebDenim(){
        driver.findElement(DenimWebSite).click();
    }
    public String getTextValue(){
        return  driver.findElement(textColor).getText();
    }

}
