package org.pageobject;

import AbstractComponent.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends CommonMethods {
    WebDriver driver;


    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> OrderProducts;

    public Boolean verifyProductOrderPage(String DesiredProduct){
        boolean res = OrderProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(DesiredProduct));
        return res;
    }


}
