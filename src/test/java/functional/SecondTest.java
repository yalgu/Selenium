package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 17.03.15
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */


public class SecondTest {

    @Test
    public void secondTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://valvesoftware.com/jobs/job_postings.html");
        WebElement foundElementByXpath = driver.findElement(By.xpath("//*[@id='psychologist_(research/experimental)']/div[1]"));
        WebElement foundElementByCssSelector = driver.findElement(By.cssSelector(".job_position_container[id*='software_engineer']"));

        assert foundElementByXpath != null;
        assert foundElementByCssSelector != null;
    }
}
