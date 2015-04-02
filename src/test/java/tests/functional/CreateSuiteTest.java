package tests.functional;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.TestSteps;
import org.testng.annotations.DataProvider;
import testLink.models.TestCase;
import testLink.models.TestSuite;


/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class CreateSuiteTest extends TestSteps{

    @DataProvider
    public Object[][] firstDataProvider() throws InterruptedException {
        return new Object[][] {
                new Object[] {"suite", "testCase" , "steps"},
                new Object[] {createTestSuite(), createTestCase(this.suiteName) , createTestSteps(this.suiteName, this.caseName)}
        };
    }

     @BeforeSuite
     public void initEnv(){
         driver = new FirefoxDriver();
         login("admin","admin");
     }

    @AfterSuite
    public void  shutEnv(){
       if ( driver != null){
           driver.quit();
       }
    }

    @Test  (dataProvider = "firstDataProvider")
    public void createSuite(TestSuite suite, TestCase testCase, Boolean steps) throws InterruptedException {
        Assert.assertTrue(suite.name != null, "Suite creation failed");
        Assert.assertTrue(testCase.name!= null, "Test case creation failed");
        Assert.assertTrue(steps, "Test steps creation failed");

    }
}
