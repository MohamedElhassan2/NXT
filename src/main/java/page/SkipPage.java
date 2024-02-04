package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkipPage extends PageBase{
    public SkipPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@type='button' and text()='Skip (only for testing)']")
    public WebElement skipBtn;
    public void clickSkip(){
        wait.until(ExpectedConditions.visibilityOf(skipBtn)).click();
    }
}
