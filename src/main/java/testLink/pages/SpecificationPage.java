package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testLink.models.TestCase;
import testLink.models.TestStep;
import testLink.models.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class SpecificationPage extends AbstractPage{

    private static final By specPage = By.xpath("//a[@accesskey='t']");
    private static final By actionsBtn = By.xpath("//img[@title='Actions']");
    private static final By createSuiteBtn = By.id("new_testsuite");
    private static final By createTestCaseBtn = By.id("create_tc");
    private static final By suiteName = By.id("name");
    private static final By testCaseName = By.id("testcase_name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By summaryFrame = By.xpath("//iframe[@title='Rich text editor, summary']");
    private static final By preconditionsFrame = By.xpath("//iframe[@title='Rich text editor, preconditions']");
    private static final By saveSuiteButton = By.name("add_testsuite_button");
    private static final By svbtn = By.xpath("//*[@name='add_testsuite_button'][@value='Save']");
    private static final By saveCaseButton = By.id("do_create_button_2");
    private static final By createStepButton = By.name("create_step");
    private static final By stepsFrame = By.xpath("//iframe[@title='Rich text editor, steps']");
    private static final By expectedResultsFrame = By.xpath("//iframe[@title='Rich text editor, expected_results']");
    private static final By saveAndExitButton = By.id("do_update_step_and_exit");

    //
    public SpecificationPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        switchToTitleBar();
        driver.findElement(specPage).click();
    }

    public void createSuite(TestSuite suite) throws InterruptedException {
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createSuiteBtn).click();
        driver.findElement(suiteName).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(suite.details);
        switchToWorkFrame();
        driver.findElement(saveSuiteButton).click();
    }

    public void createTestCase(String testSuiteName, TestCase testcase) throws InterruptedException {
        switchToTreeFrame();
        driver.findElement(By.partialLinkText(testSuiteName)).click();
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createTestCaseBtn).click();

        driver.findElement(testCaseName).sendKeys(testcase.name);
        driver.switchTo().frame(driver.findElement(summaryFrame));
        driver.findElement(frameBody).sendKeys(testcase.details);
        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(preconditionsFrame));
        driver.findElement(frameBody).sendKeys(testcase.preconditions);
        switchToWorkFrame();
        driver.findElement(saveCaseButton).click();
    }

    public void createTestStep(String testSuiteName, String testCaseName, TestStep testStep, int stepNumber) throws InterruptedException {
//        if (stepNumber == 0){
//        switchToTreeFrame();
//        driver.findElement(By.xpath("//*[contains(text(), testCaseName )]")).click();
//          }
//        switchToWorkFrame();
       // switchToForm();
        switchToWorkFrame();
        driver.findElement(createStepButton).click();

        driver.switchTo().frame(driver.findElement(stepsFrame));
        driver.findElement(frameBody).sendKeys(testStep.step[stepNumber]);
        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(expectedResultsFrame));
        driver.findElement(frameBody).sendKeys(testStep.expectedResult[stepNumber]);
        switchToWorkFrame();
        driver.findElement(saveAndExitButton).click();
    }
}
