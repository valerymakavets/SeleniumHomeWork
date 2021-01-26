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
import page.GoogleCloudPage;
import page.PastebinHomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HurtMePlenty {

    private WebDriver driver;

    public static GoogleCloudPage googleCloudPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        googleCloudPage = new GoogleCloudPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(description = "Name of the test #3")
    public void searchCalculator() {

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


        WebElement numberOfInstancesInput = driver.findElement(By.xpath("//*[@id='input_63']"));
        numberOfInstancesInput.sendKeys("4");


        WebElement openSeries = driver.findElement(By.xpath("//*[@id='select_88']"));
        openSeries.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_188']")));

        WebElement selectN1 = driver.findElement(By.xpath("//*[@id='select_option_188']"));
        selectN1.click();


        WebElement openMachineType = driver.findElement(By.xpath("//*[@id='select_90']"));
        openMachineType.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select_option_360']")));

        WebElement selectN1Standard8 = driver.findElement(By.xpath("//*[@id='select_option_360']"));
        selectN1Standard8.click();


        WebElement selectAddGpuCheckbox = driver.findElement(By.cssSelector("#mainForm>div:nth-child(3)>div>md-card>md-card-content>div>div:nth-child(1)>form>div:nth-child(10)>div.layout-column.flex-gt-sm-90.flex-80>md-input-container>md-checkbox"));
        selectAddGpuCheckbox.click();


        WebElement openNumberOfGpuDropdown = driver.findElement(By.xpath("//*[@id='select_394']"));
        openNumberOfGpuDropdown.click();


        WebElement selectNumberOfGpu1 = driver.findElement(By.xpath("//*[@id='select_option_399']"));
        selectNumberOfGpu1.click();


        WebElement openGpuTypeDropdown = driver.findElement(By.xpath("//*[@id='select_396']"));
        openGpuTypeDropdown.click();


        WebElement selectTeslaV100 = driver.findElement(By.xpath("//*[@id='select_option_406']"));
        selectTeslaV100.click();


        WebElement openLocalSsdDropdown = driver.findElement(By.xpath("//*[@id='select_355']"));
        openLocalSsdDropdown.click();


        WebElement selectSsd2 = driver.findElement(By.xpath("//*[@id='select_option_381']"));
        selectSsd2.click();


        WebElement openDatacenterLocationDropdown = driver.findElement(By.xpath("//*[@id='select_92']"));
        openDatacenterLocationDropdown.click();


        WebElement selectFrankfurt = driver.findElement(By.xpath("//*[@id='select_option_205']"));
        selectFrankfurt.click();


        WebElement openCommittedUsage = driver.findElement(By.xpath("//*[@id='select_99']"));
        openCommittedUsage.click();


        WebElement select1Year = driver.findElement(By.xpath("//*[@id='select_option_97']"));
        select1Year.click();


        WebElement AddToEstimateButton = driver.findElement(By.cssSelector("#mainForm>div:nth-child(3)>div>md-card>md-card-content>div>div:nth-child(1)>form>div.layout-align-end-start.layout-row>button"));
        AddToEstimateButton.click();



        //new WebDriverWait(driver,10)
        //.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#compute>md-list>md-list-item:nth-child(4)>div")));

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
