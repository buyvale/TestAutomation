package Selenium.etsy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EtsyBase {

    public static WebDriver wb;
    @BeforeAll
    public static void setUp() {
        ChromeOptions opt = new ChromeOptions();
        wb = new ChromeDriver(opt);
        wb.manage().deleteAllCookies();
    }

    @AfterAll
    public static void teardown() {
        wb.quit();
    }

}
