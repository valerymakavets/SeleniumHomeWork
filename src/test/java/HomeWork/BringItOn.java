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

        String pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String pasteName = "how to gain dominance among developers";

        pastebinHomePage.inputPasteText(pasteText);

        pastebinHomePage.openSyntaxHighlightingDropdown();

        List<WebElement> selectSyntaxHighlighting = driver.findElements(By.xpath("//*[@class='select2-results__option']"));
        selectSyntaxHighlighting.get(1).click();

        pastebinHomePage.openExpirationDropdown();

        List<WebElement> selectExpiration = driver.findElements(By.xpath("//*[@class='select2-results__option']"));
        selectExpiration.get(1).click();

        pastebinHomePage.inputPasteName(pasteName);

        pastebinHomePage.clickCreateNewPasteButton();

        Assert.assertEquals(pastebinPublishedPastePage.getPasteNameText(), pasteName);
        Assert.assertEquals(pastebinPublishedPastePage.getSyntaxNameText(), "Bash");
        Assert.assertEquals(pastebinPublishedPastePage.getPasteInputtedText(), pasteText);
    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }
}
