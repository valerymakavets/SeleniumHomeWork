package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HurtMePlenty {

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

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#compute>md-list>md-list-item:nth-child(4)>div")));

        WebElement checkVMClass = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(4)>div"));
        WebElement checkInstanceType = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(6)>div"));
        WebElement checkRegion = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(8)>div"));
        WebElement checkLocalSsd = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(10)>div"));
        WebElement checkCommitmentTerm = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(12)>div"));
        WebElement checkTotalCost = driver.findElement(By.cssSelector("#compute>md-list>md-list-item:nth-child(14)>div"));


        Assert.assertTrue(checkVMClass.getText().contains("regular"),"NE MOLODEC");
        Assert.assertTrue(checkInstanceType.getText().contains("n1-standard-8"),"NE MOLODEC2");
        Assert.assertTrue(checkRegion.getText().contains("Frankfurt"),"NE MOLODEC3");
        Assert.assertTrue(checkLocalSsd.getText().contains("2x375"),"NE MOLODEC4");
        Assert.assertTrue(checkCommitmentTerm.getText().contains("1 Year"),"NE MOLODEC5");
        Assert.assertTrue(checkTotalCost.getText().contains("1,082.77"),"NE MOLODEC6");

    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
        driver.quit();
        driver=null;
    }

}
