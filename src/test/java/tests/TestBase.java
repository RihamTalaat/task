package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BrowserAction;
import utility.HelperClass;
/*
this class for methods that run after and before Test case
 */

public class TestBase {
    public   WebDriver driver;
    public BrowserAction browserAction;


   @Parameters("browser")
    @BeforeClass
    public void beforeClass(@Optional("chrome") String browser) {
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup(browser);
        browserAction.maxBrowser();

    }
     @AfterTest
    public void afterClass() {
//          browserAction.closeBrowser();
//           driver.quit();
    }
   @AfterMethod
    public  void screenshotOnFail(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            System.out.println("Fail ...taking screenshot");
            HelperClass.screenshotMethod(driver, result.getTestName());
        }

}
}
