package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlueHoodiePage {

    WebDriver driver;

    By addToCart= By.xpath("//*[@id=\"post-1378\"]/div/section/div[1]/div[3]/form/div[8]/div[2]/input");

    By addPlusButton=By.xpath("//*[@id=\"post-1378\"]/div/section/div[1]/div[3]/form/div[8]/div[1]/input[3]");

    By blueHoodiePrice=By.xpath("//*[@id=\"post-1378\"]/div/section/div[1]/div[3]/form/div[2]/span[2]");

    public BlueHoodiePage(WebDriver driver){
        this.driver=driver;
    }
    public void clickAddToCart(){
        try {
            driver.findElement(addToCart).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void clickPlusButton(){
        try {
            driver.findElement(addPlusButton).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  float blueHoodiePrice(){
        WebElement cartShippingTotalV=driver.findElement(blueHoodiePrice);
        String cleanedString = cartShippingTotalV.getText().replace("$", "");
        return Float.parseFloat(cleanedString);
    }


}
