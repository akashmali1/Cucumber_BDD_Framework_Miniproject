package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverUtil;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverUtil.openBrowser("chrome");
    }

    @After
    public void tearDown() {
        DriverUtil.quitBrowser();
    }
}
