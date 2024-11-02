package AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.CartPage;
import org.pageobject.OrdersPage;
import java.time.Duration;

public class CommonMethods {

    WebDriver driver;
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement AddToCartButton;

    @FindBy(css="[routerlink*='/dashboard/myorders']")
    WebElement OrdersButton;

    public void waitForElementAppear(WebElement AElement){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
       //
        w.until(ExpectedConditions.visibilityOf(AElement));
    }
    public void waitForElementVisible(By loc){
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void waitForElementDisAppear(WebElement DElement) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOf(DElement));
    }

    public CartPage goTOCartPage(){
        AddToCartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrdersPage goToOrdersPage(){
        OrdersButton.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }





}
