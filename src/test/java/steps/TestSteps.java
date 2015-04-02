package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testLink.models.TestCase;
import testLink.models.TestStep;
import testLink.models.TestSuite;
import testLink.pages.LoginPage;
import testLink.pages.SpecificationPage;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public class TestSteps {

    protected WebDriver driver;
    protected String suiteName;
    protected String caseName;

    public boolean login(String login, String password){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open();
        return loginpage.login(login, password).isOpened();
    }

    public TestSuite createTestSuite() throws InterruptedException {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        TestSuite suite = new TestSuite();
        specificationPage.createSuite(suite);
        this.suiteName=suite.name;
        return suite;
    }

    public TestCase createTestCase(String suiteName) throws InterruptedException {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        TestCase testCase = new TestCase();
        specificationPage.createTestCase(suiteName, testCase);
        this.caseName=testCase.name;
        return testCase;
    }

    public Boolean createTestSteps(String suiteName, String testCaseName) throws InterruptedException {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        TestStep testStep = new TestStep();
        for (int i = 0; i<3; i++){
            specificationPage.createTestStep(suiteName, testCaseName, testStep, i);
            System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIII "+i);
        }
        return true;
    }
}
