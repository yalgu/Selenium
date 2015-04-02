package testLink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 20.03.15
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends AbstractPage{

     static  private final String URL = "http://demo.testlink.org/latest/login.php";

    private static  By loginField = By.id("login");
    private static  By passwordField = By.name("tl_password");
    private static By loginButton = By.name("login_submit");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void open(){
      driver.get(URL);
    }
    public HomePage login(String login, String password){
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

}
