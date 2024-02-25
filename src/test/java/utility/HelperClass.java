package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {
    public  static void  screenshotMethod(WebDriver driver ,String screenshotName){
        Path des=Paths.get("./screenShoots",screenshotName+".png");
        try {
            Files.createDirectories(des.getParent());
            FileOutputStream out=new FileOutputStream(des.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot");
        }

    }
    public static String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        return "test" + uuid.substring(0, 8) + "@example.com";
    }

}
