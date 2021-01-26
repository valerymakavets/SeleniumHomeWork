package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudPage;
import page.PastebinHomePage;
import page.PastebinPublishedPastePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BringItOn {

    private WebDriver driver;

    public static PastebinHomePage pastebinHomePage;
    public static PastebinPublishedPastePage pastebinPublishedPastePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pastebinHomePage = new PastebinHomePage(driver);
        pastebinPublishedPastePage = new PastebinPublishedPastePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (description = "Name of the test #2")

    public void newPaste() {

        driver.get("https://pastebin.com");

        pastebinHomePage.inputPasteText("git config --global user.name  \\\"New Sheriff in Town\\\"\\n\" +\n" +
                "                \"git reset $(git commit-tree HEAD^{tree} -m \\\"Legacy code\\\")\\n\" +\n" +
                "                \"git push origin master --force");


        pastebinHomePage.openSyntaxHighlightingDropdown();

        List<WebElement> selectSyntaxHighlighting = driver.findElements(By.xpath("//*[@class='select2-results__option']"));
        selectSyntaxHighlighting.get(1).click();

        pastebinHomePage.openExpirationDropdown();

        List<WebElement> selectExpiration = driver.findElements(By.xpath("//*[@class='select2-results__option']"));
        selectExpiration.get(1).click();

        pastebinHomePage.inputPasteName("how to gain dominance among developers");

        pastebinHomePage.clickCreateNewPasteButton();

        String pasteName = pastebinPublishedPastePage.getPasteNameText();
        String syntaxName = driver.findElement(By.xpath("//*[@class='left']")).getText();
        String codeText = driver.findElement(By.xpath("//*[@class='source']")).getText();

        Assert.assertEquals(pasteName, "how to gain dominance among developers");
        Assert.assertTrue(syntaxName.contains("Bash"));
        Assert.assertTrue(codeText.contains("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force"));
    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }
}
