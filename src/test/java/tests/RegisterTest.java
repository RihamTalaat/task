package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utility.HelperClass;
/*
this class for login page locators and methods
 */

public class RegisterTest extends TestBase {
  HomePage homePage;
  LoginPage loginPage;
  RegisterPage registerPage;
  MyAccountPage myAccountPage;
  ProfilePage profilePage;
  ChangePasswordPage changePasswordPage;

  @Test
  public void RegisterWithValidData() {
    String email = HelperClass.generateRandomEmail();
    homePage = new HomePage(driver);
    homePage.navigateToHomePage();
    homePage.UserCanSignIn();
    loginPage = new LoginPage(driver);
    loginPage.userCanCreateNewAccount();
    registerPage = new RegisterPage(driver);
    registerPage.UserCanRegister("firstname", "lastname", email, "12345678");

    myAccountPage = new MyAccountPage(driver);
    myAccountPage.userCanGoMyAccount();
    profilePage = new ProfilePage(driver);
    profilePage.userCanUploadPhoto();
    profilePage.userCanChangePassword();
    changePasswordPage = new ChangePasswordPage(driver);
    changePasswordPage.userCanEnterNewPassword("12345678", "23456789");
    changePasswordPage.userCanSignOut();
    homePage.UserCanSignIn();
    loginPage.userCanSignIn(email, "12345678");
  }

}
