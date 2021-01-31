package HomeWork;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudPage;
import page.GoogleCloudPricingCalculatorPage;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Hardcore {

    private WebDriver driver;

    public static GoogleCloudPage googleCloudPage;
    public static GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        googleCloudPage = new GoogleCloudPage(driver);
        googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Name of the test #4")
    public void searchCalculator() throws InterruptedException {

        driver.get("https://cloud.google.com/");

        googleCloudPage.searchTheValue();

        List<WebElement> searchCalculator = driver.findElements(By.xpath("//*[@class='devsite-result-item devsite-nav-label']"));
        searchCalculator.get(0).click();

        WebElement GoogleCloudCalculatorLink = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        GoogleCloudCalculatorLink.click();


        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));

        driver.switchTo().frame(0);

        googleCloudPricingCalculatorPage.inputTheNumberOfInstances();

        googleCloudPricingCalculatorPage.openSeriesDropdown();

        Thread.sleep(2000);

        WebElement selectN1 = driver.findElement(By.xpath("//*[@value='n1']"));
        selectN1.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.openMachineTypeDropdown();

        Thread.sleep(2000);

        WebElement selectN1Standard8 = driver.findElement(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
        selectN1Standard8.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.selectAddGpuCheckbox();

        googleCloudPricingCalculatorPage.openNumberOfGpuDropdown();

        Thread.sleep(2000);

        WebElement selectNumberOfGpu1 = driver.findElement(By.xpath("//*[@id='select_option_399']"));
        selectNumberOfGpu1.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.openGpuTypeDropdown();

        Thread.sleep(2000);

        WebElement selectTeslaV100 = driver.findElement(By.xpath("//*[@id='select_option_406']"));
        selectTeslaV100.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.openLocalSsdDropdown();

        Thread.sleep(2000);

        WebElement selectSsd2 = driver.findElement(By.xpath("//*[@id='select_option_381']"));
        selectSsd2.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.openDatacenterLocationDropdown();

        Thread.sleep(2000);


        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id='select_option_205']"));
        selectFrankfurt.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.openCommittedUsageDropdown();

        Thread.sleep(2000);

        WebElement select1Year = driver.findElement(By.xpath("//*[@id='select_option_97']"));
        select1Year.click();

        Thread.sleep(2000);

        googleCloudPricingCalculatorPage.clickAddToEstimateIstancesButton();

        Thread.sleep(2000);


        String checkTotalCost = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(14)>div")).getText();
        String premiumInCalculator = checkTotalCost.replaceAll("Estimated Component Cost: ","").replaceAll(" per 1 month","");

        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://10minutemail.net/?lang=ru");

        Thread.sleep(2000);

        String CopyEmail = driver.findElement(By.xpath("//*[@id='fe_text']")).getAttribute("value");

        driver.switchTo().window(tabs.get(0));

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));

        driver.switchTo().frame(0);

        Thread.sleep(2000);

        WebElement EmailEstimateButton = driver.findElement(By.xpath("//*[@id='email_quote']"));
        EmailEstimateButton.click();

        Thread.sleep(2000);

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@class='md-dialog-container ng-scope']")));

        Thread.sleep(2000);

        WebElement EmailField = driver.findElement(By.cssSelector("div:nth-child(3)>md-input-container>input"));
        EmailField.click();
        EmailField.sendKeys(CopyEmail);

        Thread.sleep(2000);

        WebElement SendEmailButton = driver.findElement(By.cssSelector("md-dialog-actions>button.md-raised.md-primary.cpc-button.md-button.md-ink-ripple"));
        SendEmailButton.click();

        Thread.sleep(2000);

        driver.switchTo().window(tabs.get(1));

        new WebDriverWait(driver,180).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Google Cloud Platform Price Estimate']")));

        Thread.sleep(4000);

        WebElement OpenEmail = driver.findElement(By.xpath("//a[text()='Google Cloud Platform Price Estimate']"));
        OpenEmail.click();

        Thread.sleep(2000);

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("ins>ins>ins>iframe#aswift_4")));

        WebElement ClosePopUp = driver.findElement(By.cssSelector("#dismiss-button>div>svg>path:nth-child(1)"));
        ClosePopUp.click();

        driver.switchTo().defaultContent();

        String PremiumInEmail = driver.findElement(By.cssSelector("td:nth-child(2)>h3")).getText();

        System.out.println(CopyEmail);
        System.out.println(PremiumInEmail);
        System.out.println(premiumInCalculator);

        Assert.assertEquals(premiumInCalculator,PremiumInEmail);
    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }

}
