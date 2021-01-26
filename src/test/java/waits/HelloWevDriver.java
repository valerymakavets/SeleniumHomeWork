package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWevDriver {

    private  WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();

    }

    @Test (description = "Name of the test #1")
    public void searchCalculator() {
        


        driver.get("https://cloud.google.com/");

        WebElement explicitWait = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='q']")));

        //new WebDriverWait(driver,10)
        //        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='q']")));
        //WebElement searchInput = driver.findElement(By.id("gsc-i-id1"));
        //searchInput.sendKeys("selenium java");

        WebElement clickButton = driver.findElement(By.xpath("//*[@name='q']"));
        clickButton.click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@name='q']")));

        WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']"));
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='devsite-result-item devsite-nav-label']")));

        List<WebElement> searchCalculator = driver.findElements(By.xpath("//*[@class='devsite-result-item devsite-nav-label']"));
        searchCalculator.get(0).click();

        //List<WebElement> searchCalculatorLink = driver.findElements(By.linkText("Google Cloud Platform Pricing Calculator"));
        //searchCalculatorLink.get(0).click();

        Assert.assertTrue(searchCalculator.size()>0,"MOLODEC");



    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }
}
