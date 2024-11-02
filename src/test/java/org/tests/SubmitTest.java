package org.tests;

import AbstractComponent.CommonMethods;
import org.openqa.selenium.WebElement;
import org.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitTest extends BaseTest {


    @Test(dataProvider = "getData", groups = {"Purchase"})
    public  void submitTest(HashMap<String,String>input) throws IOException, InterruptedException {

        ProductCatalogue pc = lp.goToLogin(input.get("email"), input.get("password"));
       List<WebElement> prodyctList= pc.getProducts();
        pc.selectProductByName(input.get("DesiredProduct"));
        pc.addToCart(input.get("DesiredProduct"));
        CartPage cartPage = pc.goTOCartPage();
        boolean match = cartPage.verifyDisplayProduct(input.get("DesiredProduct"));
        //System.out.println(match);
        Assert.assertTrue(match);
       CheckoutPage checkoutPage = cartPage.clickCheckButton();
        ConfirmationPage cnfrm = checkoutPage.chooseCountry();
       String msg =  cnfrm.getFinalMsg();
       Assert.assertEquals(msg,"THANKYOU FOR THE ORDER.");
    }

    @Test(dependsOnMethods = {"submitTest"})
    public void orderHistory(){
        String DesiredProduct = "ZARA COAT 3";
        ProductCatalogue pc = lp.goToLogin("chauhanrohit9936@gmail.com", "Gopalsharma@99");
        OrdersPage ordersPage = pc.goToOrdersPage();
        ordersPage.verifyProductOrderPage(DesiredProduct);
        Assert.assertTrue(ordersPage.verifyProductOrderPage(DesiredProduct));
    }

//    @DataProvider //passing data through arrays
//    public Object[][] getData() {
//        return new Object[][]{{"chauhanrohit9936@gmail.com", "Gopalsharma@99", "ADIDAS ORIGINAL"}, {"chauhanrohittt9936@gmail.com", "Gopalsharma#99", "IPHONE 13 PRO"}};
//
//    }



    //@DataProvider// passing data through Hashmap

//    public Object[][] getData(){
//        HashMap<String,String> map = new HashMap<String ,String>();
//        map.put("email","chauhanrohit9936@gmail.com");
//        map.put("password","Gopalsharma@99");
//        map.put("DesiredProduct","ADIDAS ORIGINAL");
//
//        HashMap<String,String> map1 = new HashMap<String ,String>();
//        map1.put("email","chauhanrohittt9936@gmail.com");
//        map1.put("password","Gopalsharma#99");
//        map1.put("DesiredProduct","IPHONE 13 PRO");
//
//        return new Object[][] {{map},{map1}};
//    }

    @DataProvider // passing data through json file
    public Object[][] getData() throws IOException {

       List<HashMap<String,String>> data= getJsonDataToMap();
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }






}
