package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleCloudPage;
import page.GoogleCloudPricingCalculatorPage;
import page.PastebinHomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HurtMePlenty {

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

    @Test(description = "Name of the test #3")
    public void searchCalculator() throws InterruptedException {

        driver.get("https://cloud.google.com/");

        //Открытие поиска и ввод поискового значения
        googleCloudPage.searchTheValue();

        //WebElement clickButton = driver.findElement(By.xpath("//*[@name='q']"));
        //clickButton.click();

        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@name='q']")));

        //WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']"));
        //searchInput.sendKeys("Google Cloud Platform Pricing Calculator");

        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='devsite-result-item devsite-nav-label']")));

        List<WebElement> searchCalculator = driver.findElements(By.xpath("//*[@class='devsite-result-item devsite-nav-label']"));
        searchCalculator.get(0).click();


        WebElement GoogleCloudCalculatorLink = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        GoogleCloudCalculatorLink.click();


        new WebDriverWait(driver,10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("devsite-iframe>iframe")));

        driver.switchTo().frame(0);

        //WebElement attachedElement1 = driver.findElement(By.xpath("//*[@id='input_63']"));
        //WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", attachedElement1);

        //WebElement selectNumberOfInstances = driver.findElement(By.xpath("//*[@id='input_63']"));
        //selectNumberOfInstances.click();

        googleCloudPricingCalculatorPage.inputTheNumberOfInstances();

        googleCloudPricingCalculatorPage.openSeriesDropdown();

        //new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_container_89']")));

        Thread.sleep(2000);

        WebElement selectN1 = driver.findElement(By.cssSelector("md-option[value = 'n1']"));
        selectN1.click();

        googleCloudPricingCalculatorPage.openMachineTypeDropdown();

        //new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_container_91']")));

        Thread.sleep(2000);

        WebElement selectN1Standard8 = driver.findElement(By.cssSelector("md-option[value = 'CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
        selectN1Standard8.click();


        googleCloudPricingCalculatorPage.selectAddGpuCheckbox();
        //WebElement selectAddGpuCheckbox = driver.findElement(By.cssSelector("div:nth-child(10)>div.layout-column.flex-gt-sm-90.flex-80>md-input-container>md-checkbox"));
        //selectAddGpuCheckbox.click();

        googleCloudPricingCalculatorPage.openNumberOfGpuDropdown();

        Thread.sleep(2000);

        WebElement selectNumberOfGpu1 = driver.findElement(By.xpath("//*[@id='select_option_399']"));
        selectNumberOfGpu1.click();

        googleCloudPricingCalculatorPage.openGpuTypeDropdown();

        Thread.sleep(2000);

        WebElement selectTeslaV100 = driver.findElement(By.xpath("//*[@id='select_option_406']"));
        selectTeslaV100.click();

        googleCloudPricingCalculatorPage.openLocalSsdDropdown();

        Thread.sleep(2000);

        WebElement selectSsd2 = driver.findElement(By.xpath("//*[@id='select_option_381']"));
        selectSsd2.click();

        googleCloudPricingCalculatorPage.openDatacenterLocationDropdown();

        Thread.sleep(2000);

        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id='select_option_205']"));
        selectFrankfurt.click();

        googleCloudPricingCalculatorPage.openCommittedUsageDropdown();

        Thread.sleep(2000);

        WebElement select1Year = driver.findElement(By.xpath("//*[@id='select_option_97']"));
        select1Year.click();

        googleCloudPricingCalculatorPage.clickAddToEstimateIstancesButton();

        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#compute>md-list>md-list-item:nth-child(4)>div")));

        WebElement checkVMClass = driver.findElement(By.cssSelector("md-list-item:nth-child(4)>div"));
        WebElement checkInstanceType = driver.findElement(By.cssSelector("md-list-item:nth-child(6)"));
        WebElement checkRegion = driver.findElement(By.cssSelector("md-list-item:nth-child(8)>div"));
        WebElement checkLocalSsd = driver.findElement(By.cssSelector("md-list-item:nth-child(10)>div"));
        WebElement checkCommitmentTerm = driver.findElement(By.cssSelector("md-list-item:nth-child(12)>div"));
        WebElement checkTotalCost = driver.findElement(By.cssSelector("md-list-item:nth-child(14)>div"));


        Assert.assertTrue(checkVMClass.getText().contains("regular"),"NE MOLODEC");
        Assert.assertTrue(checkInstanceType.getText().contains("Instance type: n1-standard-8"), "NE N1");
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
