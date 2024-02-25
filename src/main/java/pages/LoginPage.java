package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variable
    WebDriver driver;
    String homeUrl = "https://courses.ultimateqa.com/users/sign_in";
    Util utilPage;

    //constrain
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
    private By elementToValidate = (By.xpath("//h2[@class='page__heading'][1]"));
    private By createANewAccountLocator = By.linkText("Create a new account");
    private By emailFieldLocator = By.id("user[email]");
    private By errorMessageLocator = By.id("notice");
    private By passwordFieldLocator = By.id("user[password]");
    private By signInButtonLocator = By.xpath("//button[contains(text(), 'Sign in')]");





    //action

    public void navigateToLoinPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void userCanCreateNewAccount() {

        Assert.assertEquals(utilPage.getText(elementToValidate),"Welcome Back!");
        driver.findElement(createANewAccountLocator).click();

    }
    public void userCanSignIn(String email,String password) {

        Assert.assertEquals(utilPage.getText(elementToValidate),"Welcome Back!");
        utilPage.setText(emailFieldLocator, email, false);
        utilPage.setText(passwordFieldLocator, password, false);
        driver.findElement(signInButtonLocator).submit();
        utilPage.assertOnMassage(errorMessageLocator,"Invalid email or password.");

    }


}

