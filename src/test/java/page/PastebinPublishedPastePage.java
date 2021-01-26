package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPublishedPastePage {

    public WebDriver driver;

    public PastebinPublishedPastePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='info-top']")
    private WebElement pasteNameText;

    @FindBy(xpath = "//*[@class='left']")
    private WebElement syntaxNameText;

    @FindBy(xpath = "//*[@class='source']")
    private WebElement pasteInputtedText;

    public String getPasteNameText(){
        pasteNameText.getText();
        return null;
    }



}
