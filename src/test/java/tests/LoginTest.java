package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
    @Test(testName = "login")
    public void login(){
        LoginPage login = new LoginPage(driver);
        login.enterUserName(userName);
        login.enterPassword(password);
        login.clickLogInBTN();
        login.clickMenuBTN();
        login.clickOnAboutLink();
        driver.navigate().back();
    }
}
