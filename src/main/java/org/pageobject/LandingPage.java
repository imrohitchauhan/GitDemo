package org.pageobject;

import AbstractComponent.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends CommonMethods {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToWebsite(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    @FindBy(id="userEmail")
    WebElement UserEmail;

    @FindBy(id="userPassword")
    WebElement UserPassword;

    @FindBy(id="login")
    WebElement LoginButton;



    @FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
    WebElement ErrorMsg;

    public ProductCatalogue goToLogin(String Email, String Password){
        UserEmail.sendKeys(Email);
        UserPassword.sendKeys(Password);
        LoginButton.click();
        ProductCatalogue pc = new ProductCatalogue(driver);
        return pc;
    }

    public String getErrorMsg(){
        waitForElementAppear(ErrorMsg);
        return ErrorMsg.getText();
    }


}
