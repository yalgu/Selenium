package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testLink.selenium.DriverWrapper;

import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionTest {
    @Test(expectedExceptions = NoSuchElementException.class)
    public void findElementWithException1() {

        boolean elementPresent=false;
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.amazon.com/");
        WebElement element = driver.findElement(By.cssSelector(".nav-input[class='nav']"));
        elementPresent = true;
        Assert.assertTrue(!elementPresent);

    }
}
