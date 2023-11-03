package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;

    //stores the locators


   By cartSubTotal=By.xpath("//*[@id=\"ec_cart_subtotal\"]");

    By cartShippingTotal=By.xpath("//*[@id=\"ec_cart_shipping\"]");

    By grandTotal=By.xpath("//*[@id=\"ec_cart_total\"]");

    By plusButton=By.xpath("//*[@id=\"ec_cartitem_row_1361917\"]/td[5]/table/tbody/tr[1]/td[3]/input");

    By clickUpdateButton=By.xpath("//*[@id=\"ec_cartitem_update_1361917\"]");

    By hostItem=By.xpath("//*[@id=\"ec_image_product_widget_anchor-bracelet_1_0\"]/img");


    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }

    public float getCartSubTotal(){
        WebElement cartSubtotal=driver.findElement(cartSubTotal);
        String cleanedString = cartSubtotal.getText().replace("$", "");
        return Float.parseFloat(cleanedString);
    }

    public float getShippingTotal(){
        WebElement cartShippingTotalV=driver.findElement(cartShippingTotal);
        String cleanedString = cartShippingTotalV.getText().replace("$", "");
        return Float.parseFloat(cleanedString);
    }

    public String getGrandTotal(){
        WebElement cartGrandTotal=driver.findElement(grandTotal);
        return cartGrandTotal.getText();
    }

    public void clickHotItem(){
        driver.findElement(hostItem).click();
    }


    public void clickUpdateButton(){
        WebElement table =driver.findElement(clickUpdateButton);
        WebElement firstRow = table.findElement(By.tagName("tr"));

        List<WebElement> columns = firstRow.findElements(By.tagName("td"));
        for (WebElement column : columns) {
            column.click();
        }

    }
}
