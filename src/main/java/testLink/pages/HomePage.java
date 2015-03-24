package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class HomePage {
    protected WebDriver driver;

    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");
    private static final By headenFrame = By.name("titlebar");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        driver.switchTo().frame(driver.findElement(headenFrame));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
       return driver.findElements(version).size() > 0 ;
    }
}
