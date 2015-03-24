package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public boolean login(String login, String password){
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open();
        return loginpage.login(login, password).isOpened();
    }

    public void openTestSpec(){
        SpecificationPage testSpecificationPage = new SpecificationPage(driver);
        testSpecificationPage.open();
        //return testSpecificationPage.open();
    }

    public void selectTestProject(){
//        driver.findElement(By.className("testproject")).click();
        driver.findElement(By.xpath("//select[contains(@name, 'testproject')]")).click();
       // driver.findElement(By.xpath("//option[contains(@link, 'TL-MN:TL - test project Mazur Nadiia')]")).click();
        driver.findElement(By.xpath("//select[contains(@name, 'testproject')]/option[text()='TL-MN:TL - test project Mazur Nadiia']")).click();
        //text()='Automation (1)'

    }
}
