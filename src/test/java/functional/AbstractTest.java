//package functional;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// * Created with IntelliJ IDEA.
// * User: Nadia
// * Date: 17.03.15
// * Time: 20:18
// * To change this template use File | Settings | File Templates.
// */
//public class AbstractTest {
//    protected ThreadLocal<WebDriver> threadDriver = null;
//    public static final String hubUrl = "http://localhost:9999/wd/hub";
//
//    @BeforeTest
//    public void create() throws MalformedURLException {
//        WebDriver driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.firefox());
//        threadDriver = new ThreadLocal<WebDriver>();
//        threadDriver.set(driver);
//    }
//    @AfterTest
//    public void close()
//    {
//        if (threadDriver.get() != null)
//            threadDriver.get().quit();
//    }
//}
