package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.pageobject.CartPage;
import org.pageobject.CheckoutPage;
import org.pageobject.LandingPage;
import org.pageobject.ProductCatalogue;
import org.tests.BaseTest;

import java.io.IOException;

public class StepDefinitionImp extends BaseTest {

   public LandingPage lp;
   public CartPage cartPage;
   public ProductCatalogue pc;
    @Given("user landed on Ecommerce page")
    public void user_landed_on_Ecommerce_page() throws IOException {
      lp = launchApp();
    }

    @Given("^user enters with (.+) and password (.+)$")
    public void user_enters_username_and_password(String username,String password){
       pc= lp.goToLogin(username,password);
    }

    @When("^user add product (.+) to cart")
    public void add_product_productname(String productName) throws InterruptedException {
       cartPage  = pc.addToCart(productName);
    }

}
