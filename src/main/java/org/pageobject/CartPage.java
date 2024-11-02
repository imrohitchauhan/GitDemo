package org.pageobject;

import AbstractComponent.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage extends CommonMethods {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".cartSection h3")
    List<WebElement> CartPageProducts;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement CheckoutButton;

    public Boolean verifyDisplayProduct(String DesiredProduct){
       boolean match = CartPageProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(DesiredProduct));
       return match;

    }

    public CheckoutPage clickCheckButton(){
        CheckoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }





}
