package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        String pasteText = "Hello from WebDriver";
        String pasteName = "helloweb";

        pastebinHomePage.inputPasteText(pasteText);

        pastebinHomePage.openExpirationDropdown();

        List<WebElement> selectExpiration = driver.findElements(By.xpath("//*[@class='select2-results__option']"));
        selectExpiration.get(1).click();

        pastebinHomePage.inputPasteName(pasteName);

    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }
}
