package org.pageobject;

import AbstractComponent.CommonMethods;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends CommonMethods {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css= ".mb-3")
    List<WebElement> AllProducts;

//    @FindBy(css= ".mb-3")
//    WebElement AppearProducts;

    By AppearProducts = By.cssSelector(".mb-3");

    @FindBy(id="toast-container")
    WebElement AppearElement;

    @FindBy(css =".ng-animating")
    WebElement DisappearElement;

    By AddtoCartButton = By.cssSelector(".card-body button:last-of-type");

    public List<WebElement> getProducts(){
        waitForElementVisible(AppearProducts);
        return AllProducts;
    }


    public WebElement selectProductByName(String DesiredProduct){

        WebElement prod = getProducts().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(DesiredProduct)).findFirst().orElse(null);
       return prod;
    }



    public CartPage addToCart(String DesiredProduct) throws InterruptedException {
        WebElement prod = selectProductByName(DesiredProduct);
        //System.out.println(prod);
        prod.findElement(AddtoCartButton).click();
        waitForElementAppear(AppearElement);
        waitForElementDisAppear(DisappearElement);
        CartPage cartPage = new CartPage(driver);
        return cartPage;


    }







}
