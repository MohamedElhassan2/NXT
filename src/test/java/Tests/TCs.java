package Tests;

import TestData.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DashBoardPage;
import page.LoginPage;
import page.SkipPage;

public class TCs extends TestBase {
    LoginPage loginPage;
    LoginData loginData;
    SkipPage skipPage;
    DashBoardPage dashBoardPage;

    @Test
    public void enterusername(){
        loginPage = new LoginPage(driver);
        loginData = new LoginData();
        skipPage = new SkipPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        loginPage.enterusername(loginData.usernameValue);
        loginPage.enterPassword(loginData.passwordValue);
        loginPage.clickLogin();
        Assert.assertTrue(skipPage.skipBtn.isDisplayed(),"Skip Screen is displayed");
        skipPage.clickSkip();
        Assert.assertTrue(DashBoardPage.myEventTitle.isDisplayed(),"Skip Screen is displayed");
    }
}
