package org.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice3 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.xe.com");
        driver.findElement(By.className("amount-input")).sendKeys("5");
        

    }
}
