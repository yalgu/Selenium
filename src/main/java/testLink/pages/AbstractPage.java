package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 24.03.15
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public class AbstractPage {
    protected WebDriver driver;
    protected static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");
    protected static final By headenFrame = By.name("titlebar");
    private static final By headeFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By workFrame = By.name("workframe");
    private static final By formStepsControl = By.id("stepsControls");
    // stepsControls

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        driver.switchTo().frame(driver.findElement(headenFrame));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return driver.findElements(version).size() > 0 ;
    }

    protected void switchToTitleBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headeFrame));
    }

    protected void switchToTreeFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

    protected void switchToWorkFrame() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    protected void switchToForm() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
        driver.switchTo().frame(driver.findElement(formStepsControl));
    }
}
