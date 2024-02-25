package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegisterPage {
    //variable
    WebDriver driver;
    String homeUrl = "https://www.phptravels.net/register";
    Util utilPage;
MyAccountPage myAccountPage;
    //constrain
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
        myAccountPage=new MyAccountPage(driver);
    }

    //element
    public By elementToValidate = By.xpath("//*[@id=\"create-account\"]/h2[@class='page__heading']");
    private By firstnameLocator = By.id("user[first_name]");
    private By lastnameLocator = By.name("user[last_name]");
    private By emailLocator = By.id("user[email]");
    private By passwordLocator = By.name("user[password]");
    private By checkboxLocator=By.id("user[terms]");
    private By signUpButtonLocator = By.xpath("//button[contains(text(), 'Sign up')]");


    //action

    public void navigateToRegisterPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void UserCanRegister(String firstName , String lastName , String email , String password) {

       Assert.assertEquals(utilPage.getText(elementToValidate),"Create a new account");
        utilPage.setText(firstnameLocator,firstName,false);
        utilPage.setText(lastnameLocator,lastName,false);
        utilPage.setText(emailLocator,email,false);
        utilPage.setText(passwordLocator,password,false);
        utilPage.clickOnCheckbox(checkboxLocator);
        utilPage.clickOnButton(signUpButtonLocator,myAccountPage.elementToValidate);

    }

}

