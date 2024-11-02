package org.pageobject;

import AbstractComponent.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends CommonMethods {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement CountryPlaceholder;

    @FindBy(css = ".ta-results")
    WebElement AllCountries;

    @FindBy(xpath ="//section/button[2]")
    WebElement SelectCountry;

    @FindBy(css = ".action__submit")
    WebElement ClickPlaceOrderButton;

    public ConfirmationPage chooseCountry(){
        Actions a = new Actions(driver);
        a.sendKeys(CountryPlaceholder,"India").build().perform();
        waitForElementAppear(AllCountries);
        a.moveToElement(SelectCountry).click().build().perform();
       a.moveToElement(ClickPlaceOrderButton).click().build().perform();
        ConfirmationPage cnfrm = new ConfirmationPage(driver);
        return cnfrm;



    }

}
