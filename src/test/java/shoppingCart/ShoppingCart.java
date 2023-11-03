package shoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    WebDriver driver;

    //stores the locators

   By addToCart= By.xpath("//*[@id=\"ec_add_to_cart_5\"]");
   By checkOut = By.xpath("//*[@id=\"ec_added_to_cart_5\"]");

   By cartSubTotal=By.xpath("//*[@id=\"ec_cart_subtotal\"]");

    By cartShippingTotal=By.xpath("//*[@id=\"ec_cart_shipping\"]");

    By grandTotal=By.xpath("//*[@id=\"ec_cart_total\"]");


   public ShoppingCart(WebDriver driver){
       this.driver=driver;
   }
   public void clickAddToCart(){
       driver.findElement(addToCart).click();
   }
    public void clickCheckOut(){
        driver.findElement(checkOut).click();
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
}
