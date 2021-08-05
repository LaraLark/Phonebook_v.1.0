import application.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
 Logger logger = LoggerFactory.getLogger(TestBase.class);

@BeforeMethod
public void startLogger(Method m){
    logger.info("Start method --->" + m.getName());
}
@AfterMethod
public void endOfLogger(Method m){
    logger.info("End of method --->" + m.getName());
}
    @BeforeSuite(alwaysRun = true)
    public void start(){
        app.init();
        app.userHelper();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }
}

