package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinHomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ICanWin {

    private WebDriver driver;

    public static PastebinHomePage pastebinHomePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinHomePage = new PastebinHomePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test (description = "Name of the test #1")

    public void newPaste() {

        driver.get("https://pastebin.com");

        pastebinHomePage.inputPasteText("Hello from WebDriver");

        pastebinHomePage.openExpirationDropdown();

        WebElement selectExpiration = driver.findElement(By.xpath("//*[@data-select2-id='select2-postform-expiration-result-ks4k-10M']"));
        selectExpiration.click();

        pastebinHomePage.inputPasteName("helloweb");

    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }
}
