package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class SpecificationPage {
    protected WebDriver driver;

    private static  By testSuiteField = By.name("name");

    public SpecificationPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.findElement(By.xpath("//div[contains(@class, 'menu_bar')]/a")).click();
   //     driver.findElement(By.xpath("//div[@class='menu_bar'/a")).click();

    }
    public void fillDataForTestSuite(){
        String testSuiteName = "123";
        driver.findElement(testSuiteField).sendKeys(testSuiteName);

    }
}
