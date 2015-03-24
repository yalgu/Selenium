package tests.functional;

import com.thoughtworks.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.TestSteps;
import testLink.models.TestSuite;

import static sun.security.jgss.GSSUtil.login;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class CreateSuiteTest extends TestSteps{
     @BeforeSuite
     public void initEnv(){
         driver = new FirefoxDriver();
     }

    @AfterSuite
    public void  shutEnv(){
       if ( driver != null){
           driver.quit();
       }
    }

    @Test
    public void createSuite() throws InterruptedException {
       TestSuite suite = new TestSuite();
       //Assert.assertTrue(login("admin", "admin"), "Login failed");
       createTestSuite(suite);

    }
}
