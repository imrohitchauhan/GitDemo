package org.tests;

import AbstractComponent.CommonMethods;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pageobject.CartPage;
import org.pageobject.ProductCatalogue;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"ErrorHandling"})

    public void LoginPageErrorValidation() throws IOException {
        lp.goToLogin("chauhanrohit9936@gmail.com", "Gopalsharma@999");
        Assert.assertEquals("Incorrect email  password.",lp.getErrorMsg());
    }

    @Test
    public void productCartValidation() throws InterruptedException {
        String DesiredProduct = "ZARA COAT 3";
        ProductCatalogue pc = lp.goToLogin("chauhanrohit9936@gmail.com", "Gopalsharma@99");
        pc.addToCart(DesiredProduct);
        CartPage cartpg = pc.goTOCartPage();
        Boolean match = cartpg.verifyDisplayProduct(DesiredProduct);
        Assert.assertTrue(match);
    }


}
