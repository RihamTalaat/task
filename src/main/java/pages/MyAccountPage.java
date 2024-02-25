package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPage {
    //variable
    WebDriver driver;
    String homeUrl = "https://courses.ultimateqa.com/collections";
    Util utilPage;

    //constrain
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
    public By elementToValidate = By.linkText("My Dashboard");
    private By dropDownButtonLocator = By.xpath("//*[@class='dropdown__toggle-button']");
    private By myAccountLocator = By.linkText("My Account");

    //action

    public void navigateToLoinPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void userCanGoMyAccount() {
       Assert.assertEquals(utilPage.getText(elementToValidate),"My Dashboard");
        utilPage.clickOnButton(dropDownButtonLocator,myAccountLocator);
        utilPage.clickOnButton(myAccountLocator);

    }

}

