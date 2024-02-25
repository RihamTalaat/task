package runnerCucumber;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = "src/test/java/featureCucumber"
        ,glue= {"stepsCucumber"}
        ,plugin= {"pretty","html:target/cucumber_html_report.html"})
public class runnerTest extends AbstractTestNGCucumberTests  {

}
