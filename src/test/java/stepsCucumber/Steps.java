package stepsCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BrowserAction;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utility.HelperClass;

public class Steps  {
    public  WebDriver driver;
    public BrowserAction browserAction;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    MyAccountPage myAccountPage;
    ProfilePage profilePage;
    ChangePasswordPage changePasswordPage;
    String email = HelperClass.generateRandomEmail();




    @Given("I am on the home page")
    public void iAmOnHomePage() {
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup("chrome");
        browserAction.maxBrowser();
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.UserCanSignIn();
        loginPage = new LoginPage(driver);
        loginPage.userCanCreateNewAccount();
        }

    @When("I register with valid details")
    public void iRegisterWithValidDetails() {
        registerPage = new RegisterPage(driver);
        registerPage.UserCanRegister("firstname", "lastname", email, "12345678");

    }

    @And("I upload a profile picture")
    public void iUploadAProfilePicture() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.userCanGoMyAccount();
        profilePage = new ProfilePage(driver);
        profilePage.userCanUploadPhoto();
    }

    @And("I change my password")
    public void iChangeMyPassword() {
        profilePage.userCanChangePassword();
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.userCanEnterNewPassword("12345678", "23456789");
    }

    @Then("I cannot login with the old password")
    public void iCannotLoginWithTheOldPassword() {
        changePasswordPage.userCanSignOut();
        homePage.UserCanSignIn();
        loginPage.userCanSignIn(email, "12345678");
       // browserAction.closeBrowser();
     // driver.quit();
    }
}