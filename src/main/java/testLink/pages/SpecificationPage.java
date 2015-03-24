package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testLink.models.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class SpecificationPage extends AbstractPage{
    protected WebDriver driver;

    private static  By testSuiteField = By.name("name");
    By speci = By.xpath("//div[contains(@class, 'menu_bar')]/a");
    By actions = By.xpath("//img[@title='Actions']/a");
    By createSuiteBtn = By.id("new_testSuite");
    By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    By frameBody = By.tagName("body");
    By saveButton = By.name("add_testsuite_button");

    public SpecificationPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        switchToTitleBar();
        driver.findElement(speci).click();
    }

    public void createSuite(TestSuite suite){
        driver.findElement(actions);
        driver.findElement(createSuiteBtn);
        driver.findElement(testSuiteField).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(suite.details);
        driver.findElement(saveButton).click();
    }
}
