package org.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageobject.LandingPage;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    LandingPage lp;
    public WebDriver invokeBrowser() throws IOException {

        Properties prop = new Properties();
        //FileInputStream fis = new FileInputStream("C:\\Users\\dell\\Selenium_Framework_Project\\src\\main\\java\\org\\example\\GlobalData.properties");
        //prop.load(fis);
        //String BrowserName = prop.getProperty("browser");
            driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.manage().window().maximize();
           return driver;

    }
    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApp() throws IOException {
        driver = invokeBrowser();
         lp = new LandingPage(driver);
        lp.goToWebsite();
        return lp;
    }

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        //read json file to string
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//JsonData//Data.json"));

        //string to hashmap
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
        return data;

    }

    public String getScreenShot(String testcaseName) throws IOException {
        driver=invokeBrowser();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+ testcaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testcaseName + ".png";
    }


}
