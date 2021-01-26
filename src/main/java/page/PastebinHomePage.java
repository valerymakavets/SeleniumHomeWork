package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PastebinHomePage {
    public WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement newPasteTextField;

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement syntaxHighlightingDropdown;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement pasteNameField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement createNewPasteButton;


    public void inputPasteText(String pastetext) {
        newPasteTextField.sendKeys(pastetext);
    }

    public void openSyntaxHighlightingDropdown(){
        syntaxHighlightingDropdown.click();
    }

    public void openExpirationDropdown(){
        pasteExpirationDropdown.click();
    }

    public void inputPasteName(String pastename) {
        pasteNameField.sendKeys(pastename);
    }

    public void clickCreateNewPasteButton() {
        createNewPasteButton.click();
    }

}
