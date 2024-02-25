package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProfilePage {
    //variable
    WebDriver driver;
    String homeUrl = "https://courses.ultimateqa.com/account";
    Util utilPage;

    //constrain
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
    public By elementToValidate = By.xpath("//h2[text()='Edit Profile']");
    private By upLoadImageLocator = By.xpath("//span[@class='button-upload']");
    private By passwordLocator = By.linkText("Password");


    //action

    public void navigateToLoinPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void userCanUploadPhoto() {
       Assert.assertEquals(utilPage.getText(elementToValidate),"Edit Profile");
     //  utilPage.uploadPhoto(upLoadImageLocator,"D:/dxl/AreebProject/src/main/resources/flower.jpg");

    }
   public void userCanChangePassword(){
        utilPage.clickOnButton(passwordLocator);
   }

}

