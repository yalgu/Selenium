package functional;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nadia
 * Date: 13.03.15
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
public class FirstTest {
    @DataProvider
    public Object[][] keywords() {
        return new Object[][] {
                //  new Object[] {"word", "ukr,net"},
                new Object[] {"осциллограф", "www.leoton.ua/oscill.php"}
        };
    }

    private static final By searchInput = By.id("lst-ib");
 //   private static final By searchUrl = By.xpath("//div[@id='search']/div[@class='s']/cite[@class='_Rm']");
    boolean containsUrl = false;

    @Test(dataProvider = "keywords")
    public void firstTest(String keyword, String url) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com.ua");
        driver.findElement(searchInput).clear();
        driver.findElement((searchInput)).sendKeys(keyword);
        driver.findElement((searchInput)).sendKeys(Keys.ENTER);

        List <WebElement> searchedUrl;
        for (int i = 0; i < 3 && !containsUrl; i++) {
            if (i != 0){
                 driver.findElement(By.xpath("//*[@id='pnnext']")).click();

            }
            Thread.sleep(1000);
            searchedUrl = driver.findElements(By.className("_Rm"));
            findUrlONCurrentPage(url, searchedUrl);
        }
        assert containsUrl;
        driver.quit();
    }

    private void findUrlONCurrentPage(String url, List<WebElement> searchedUrl) {
        for (int j = 0; j < searchedUrl.size() && !containsUrl == false; j++){
           containsUrl = searchedUrl.get(j).getText().equals(url);
        }
    }





}
