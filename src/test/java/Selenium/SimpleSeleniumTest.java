package Selenium;

import com.google.common.collect.Multimaps;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleSeleniumTest {

    private static WebDriver wb;
    private List<String> urlList = Arrays.asList("https://www.google.com/",
            "https://www.ebay.com/",
            "https://www.etsy.com/?ref=lgo");
    private List<String> listQueryString = Arrays.asList("cat", "elephant", "t-shirt");
    private String queryString;

    @BeforeAll
    public static void setUp() {
        // System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        wb = new ChromeDriver(opt);
    }


    @BeforeEach
    public void setUpDefaultEbaySearchQuery()
    {
        queryString  = listQueryString.get(0);
        wb.get(urlList.get(1));
        WebElement searchField = wb.findElement(By.name("_nkw"));
        searchField.sendKeys(queryString);
        searchField.submit();
    }

    @Test
    public void googleSimpleTest() {
        String queryString = "selenium";
        wb.get(urlList.get(0));
        WebElement searchField = wb.findElement(By.name("q"));
        searchField.sendKeys("selenium" + Keys.ENTER);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(wb.getTitle().contains(queryString));
    }

    @Test
    public void firstEbaySearchSimpleTest() {

        Assertions.assertTrue(wb.getTitle().contains(queryString));

    }

    @Test
public void sortByPricePlusShippingLowestFirstTest()
    {
       // WebElement firstItemPrice = wb.findElement(By.xpath("//*[@id=\"item3b1b69f22c\"]/ul[1]/li[1]/span"));
//       // WebElement thirdItemPrice = wb.findElement(By.name("//*[@id=\"item3d6d4395e2\"]/ul[1]/li[1]/span"));
        WebElement sortMenuComboBox = wb.findElement(By.xpath("//*[@id=\"DashSortByContainer\"]/ul[1]/li/div/a"));
        sortMenuComboBox.findElement(By.linkText("Price + Shipping: highest first")).click();

    }

    @AfterAll
    public static void teardown() {
        wb.quit();
    }

}

