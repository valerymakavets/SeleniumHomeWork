package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculatorPage {

    public WebDriver driver;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='input_63']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[@id='select_88']")
    private WebElement seriesField;

    @FindBy(xpath = "//*[@id='select_90']")
    private WebElement machineTypeField;

    @FindBy(css = "div:nth-child(10)>div.layout-column.flex-gt-sm-90.flex-80>md-input-container>md-checkbox")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//*[@id='select_394']")
    private WebElement numberOfGpuDropdown;

    @FindBy(xpath = "//*[@id='select_396']")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//*[@id='select_355']")
    private WebElement localSsdDropdown;

    @FindBy(xpath = "//*[@id='select_92']")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//*[@id='select_99']")
    private WebElement committedUsageDropdown;

    @FindBy(css = "div:nth-child(1)>form>div.layout-align-end-start.layout-row>button")
    private WebElement addToEstimateInstancesButton;


    public void openSeriesDropdown(){
        seriesField.click();
    }

    public void inputTheNumberOfInstances() {
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys("4");
    }
    public void openMachineTypeDropdown(){
        machineTypeField.click();
    }

    public void selectAddGpuCheckbox(){
        addGpuCheckbox.click();
    }

    public void openNumberOfGpuDropdown(){
        numberOfGpuDropdown.click();
    }

    public void openGpuTypeDropdown(){
        gpuTypeDropdown.click();
    }

    public void openLocalSsdDropdown(){
        localSsdDropdown.click();
    }

    public void openDatacenterLocationDropdown(){
        datacenterLocationDropdown.click();
    }

    public void openCommittedUsageDropdown(){
        committedUsageDropdown.click();
    }

    public void clickAddToEstimateIstancesButton(){
        addToEstimateInstancesButton.click();
    }
}
