package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    //variable
    WebDriver driver;
    String homeUrl = "https://courses.ultimateqa.com/collections";
    Util utilPage;

    //constrain
    public HomePage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
    private By elementToValidate = By.xpath("//*[@id=\"main-content\"]/div/h2");
    private By signUpButtonLocator = By.linkText("Sign In");

    //action

    public void navigateToHomePage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void UserCanSignIn() {
       //Assert.assertEquals(utilPage.getText(elementToValidate),"Products");
        driver.findElement(signUpButtonLocator).click();

    }


}

