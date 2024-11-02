package org.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        WebDriverWait wait;
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.xe.com/");
             wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement amountInput = driver.findElement(By.xpath("//span[@class='amount-input']/input[@type='text']"));
            amountInput.clear();
            amountInput.sendKeys("12");
            driver.findElement(By.xpath("//input[@aria-describedby='midmarketFromCurrency-current-selection']")).sendKeys("US");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("midmarketFromCurrency-listbox")));
            List<WebElement> fromOptions = driver.findElements(By.xpath("//ul[@id='midmarketFromCurrency-listbox']/li"));
            fromOptions.stream().filter(option->option.getText().contains("US")).findFirst().ifPresent(WebElement::click);

            driver.findElement(By.xpath("//input[@aria-describedby='midmarketToCurrency-current-selection']")).sendKeys("INR");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='midmarketToCurrency-listbox']/li")));
            List<WebElement> toOptions = driver.findElements(By.xpath("//ul[@id='midmarketToCurrency-listbox']/li"));
            toOptions.stream().filter(option->option.getText().contains("INR")).findFirst().ifPresent(WebElement::click);

            driver.findElement(By.xpath("//button[text()='Convert']")).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.sc-423c2a5f-1.gPUWGS")));
            System.out.println(driver.findElement(By.cssSelector("p.sc-423c2a5f-1.gPUWGS")).getText());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
