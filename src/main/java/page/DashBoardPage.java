package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageBase{
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[text()='My Events']")
    public static WebElement myEventTitle;

}
