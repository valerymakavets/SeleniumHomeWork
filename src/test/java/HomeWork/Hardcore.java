package HomeWork;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class Hardcore {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://cloud.google.com/");

    }

    @Test(description = "Name of the test #1")
    public void searchCalculator() throws InterruptedException {

        //WebElement clickButton = driver.findElement(By.xpath("//*[@name='q']"));
        //clickButton.click();

        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@name='q']")));

        //WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']"));
        //searchInput.sendKeys("Google Cloud Platform Pricing Calculator");

        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='devsite-result-item devsite-nav-label']")));

        //List<WebElement> searchCalculator = driver.findElements(By.xpath("//*[@class='devsite-result-item devsite-nav-label']"));
        //searchCalculator.get(0).click();


        //WebElement element = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        //element.click();



        driver.get("https://cloud.google.com/products/calculator");

        Thread.sleep(2000);


        driver.manage().window().maximize();

        Thread.sleep(2000);


        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));

        driver.switchTo().frame(0);

        //WebElement attachedElement1 = driver.findElement(By.xpath("//*[@id='input_63']"));
        //WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", attachedElement1);





        WebElement selectNumberOfInstances = driver.findElement(By.xpath("//*[@id='input_63']"));
        selectNumberOfInstances.click();



        WebElement numberOfInstancesInput = driver.findElement(By.xpath("//*[@id='input_63']"));
        numberOfInstancesInput.sendKeys("4");



        WebElement openSeries = driver.findElement(By.xpath("//*[@id='select_88']"));
        openSeries.click();

        Thread.sleep(2000);

        WebElement selectN1 = driver.findElement(By.xpath("//*[@value='n1']"));
        selectN1.click();

        Thread.sleep(2000);

        WebElement openMachineType = driver.findElement(By.xpath("//*[@id='select_90']"));
        openMachineType.click();

        Thread.sleep(2000);

        WebElement selectN1Standard8 = driver.findElement(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
        selectN1Standard8.click();

        Thread.sleep(2000);

        WebElement selectAddGpuCheckbox = driver.findElement(By.cssSelector("#mainForm>div:nth-child(3)>div>md-card>md-card-content>div>div:nth-child(1)>form>div:nth-child(10)>div.layout-column.flex-gt-sm-90.flex-80>md-input-container>md-checkbox"));
        selectAddGpuCheckbox.click();

        Thread.sleep(2000);

        WebElement openNumberOfGpuDropdown = driver.findElement(By.xpath("//*[@id='select_394']"));
        openNumberOfGpuDropdown.click();

        Thread.sleep(2000);

        WebElement selectNumberOfGpu1 = driver.findElement(By.xpath("//*[@id='select_option_399']"));
        selectNumberOfGpu1.click();

        Thread.sleep(2000);

        WebElement openGpuTypeDropdown = driver.findElement(By.xpath("//*[@id='select_396']"));
        openGpuTypeDropdown.click();

        Thread.sleep(2000);

        WebElement selectTeslaV100 = driver.findElement(By.xpath("//*[@id='select_option_406']"));
        selectTeslaV100.click();

        Thread.sleep(2000);

        WebElement openLocalSsdDropdown = driver.findElement(By.xpath("//*[@id='select_355']"));
        openLocalSsdDropdown.click();

        Thread.sleep(2000);

        WebElement selectSsd2 = driver.findElement(By.xpath("//*[@id='select_option_381']"));
        selectSsd2.click();

        Thread.sleep(2000);


        WebElement openDatacenterLocationDropdown = driver.findElement(By.xpath("//*[@id='select_92']"));
        openDatacenterLocationDropdown.click();

        Thread.sleep(2000);


        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id='select_option_205']"));
        selectFrankfurt.click();

        Thread.sleep(2000);

        WebElement openCommittedUsage = driver.findElement(By.xpath("//*[@id='select_99']"));
        openCommittedUsage.click();

        Thread.sleep(2000);

        WebElement select1Year = driver.findElement(By.xpath("//*[@id='select_option_97']"));
        select1Year.click();

        Thread.sleep(2000);

        WebElement AddToEstimateButton = driver.findElement(By.cssSelector("#mainForm>div:nth-child(3)>div>md-card>md-card-content>div>div:nth-child(1)>form>div.layout-align-end-start.layout-row>button"));
        AddToEstimateButton.click();

        Thread.sleep(2000);

        String checkTotalCost = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(14)>div")).getText();

        WebElement EmailEstimateButton = driver.findElement(By.xpath("//*[@id='email_quote']"));
        EmailEstimateButton.click();

        Thread.sleep(2000);

        //SWITCH TO EMAIL!!!!!!!!!!!!!

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));



        //driver.findElement(By.xpath("//*[@class='devsite-tabs-wrapper']")).sendKeys(Keys.CONTROL +"t");


        //WebElement openNewTab = driver.findElement(By.cssSelector("body"));
        //openNewTab.sendKeys(Keys.CONTROL + "t");

        Thread.sleep(2000);

        driver.get("https://10minutemail.com/");


        Thread.sleep(2000);

        String CopyEmail = driver.findElement(By.xpath("//*[@id='copy_address']")).getText();

        driver.switchTo().window(tabs.get(0));

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='myFrame']")));

        WebElement EmailField = driver.findElement(By.xpath("//*[@id='input_482']"));
        EmailField.sendKeys(CopyEmail);

        Thread.sleep(2000);

        WebElement SendEmailButton = driver.findElement(By.cssSelector("#dialogContent_390>form>md-dialog-actions>button.md-raised.md-primary.cpc-button.md-button.md-ink-ripple"));
        SendEmailButton.click();

        Thread.sleep(2000);

        driver.switchTo().window(tabs.get(1));

        new WebDriverWait(driver,50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mail_message']")));

        WebElement OpenEmail = driver.findElement(By.xpath("//*[@class='mail_message']"));
        OpenEmail.click();

        Thread.sleep(2000);

        String PremiumInEmail = driver.findElement(By.cssSelector("#mobilepadding>td>h2")).getText();


        Assert.assertTrue(checkTotalCost.contains(PremiumInEmail),"NE MOLODEC6");

    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }

}
