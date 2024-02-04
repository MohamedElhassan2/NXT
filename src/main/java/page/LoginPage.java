package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
   public WebElement username;
    @FindBy(xpath = "//input[@type='password' and @id='password' and @name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit' and text()='Login']")
    WebElement loginBtn;



    public void enterusername(String usernameValue){
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(usernameValue);
    }
    public void enterPassword(String passwordValue){
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwordValue);
    }
    public void clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

}
