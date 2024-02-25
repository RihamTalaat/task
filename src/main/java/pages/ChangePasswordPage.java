package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChangePasswordPage {
  //variable
  WebDriver driver;
  String homeUrl = "https://courses.ultimateqa.com/account/password";
  Util utilPage;

  //constrain
  public ChangePasswordPage(WebDriver driver) {
    this.driver = driver;
    utilPage = new Util(this.driver);
  }

  //element
  public By elementToValidate = By.xpath("//h2[text()='Change Password']");
  private By changePasswordFieldLocator = By.xpath("//*[@id='user[password]']");
  private By confirmPasswordFieldLocator = By.xpath("//*[@id='user[password_confirmation]']");
  private By currentPasswordFieldLocator = By.xpath("//*[@id='user[current_password]']");
  private By updateButtonLocator = By.xpath("//*[@name='commit']");
  private By dropDownButtonLocator = By.xpath("//button[@class='dropdown__toggle-button']");
  private By signOutLocator = By.linkText("Sign Out");



  //action

  public void navigateToLoinPage() {
    utilPage.navigateToPage(homeUrl, elementToValidate);
  }


  public void userCanEnterNewPassword(String oldPassword, String newPassword) {
    Assert.assertEquals(utilPage.getText(elementToValidate), "Change Password");
    utilPage.setText(changePasswordFieldLocator, newPassword, false);
    utilPage.setText(confirmPasswordFieldLocator, newPassword, false);
    utilPage.setText(currentPasswordFieldLocator, oldPassword, false);
    driver.findElement(updateButtonLocator).submit();

  }


  public void userCanSignOut() {
    utilPage.clickOnButton(dropDownButtonLocator, signOutLocator);
    utilPage.clickOnButton(signOutLocator);

  }

}

