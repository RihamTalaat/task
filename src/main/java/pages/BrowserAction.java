package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserAction {
  /*
  this class  for browser action  open, close,max,and navigate to urls
   */
   private WebDriver driver;

  public BrowserAction(WebDriver driver) {

    this.driver = driver;
  }

  public WebDriver driverSetup(String browser) {
    try {
      if (browser.equals("chrome")) {
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
      } else if (browser.equals("fireFox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
      } else {
        System.out.println("browser are not correct");
        return null;
      }

    } catch (Exception e) {
      System.out.println("cant open browser");
      return null;
    }

  }

  public void maxBrowser() {
    driver.manage().window().maximize();
  }

  public void driveNavigate(String URL) {
    try {
      driver.navigate().to(URL);
      System.out.println("the current title is: " + driver.getTitle());
    } catch (Exception e) {
      System.out.println("can't navigate to page " + URL);
    }
  }

  public void closeBrowser() {
    driver.quit();

  }
}
