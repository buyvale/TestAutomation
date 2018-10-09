package Selenium.Ebay;

import Selenium.Ebay.pageObject.EbayComPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class EbayComTest {
    protected static WebDriver webDriver;
    EbayComPageObject ebayPage;

    @BeforeAll
    public static void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeEach
    public void setUpForEach() {
        ebayPage = new EbayComPageObject(webDriver);
    }

    @Test
    public void shouldShowBestPricesWhenSelectAuctionAfterSearch() {
        ebayPage.goToMainPage()
                .searchFor("leather bags")
                .selectAuction();
        assertThat(ebayPage.getAuctionBestPrices(),
                containsInAnyOrder("Under $8.00", "$8.00 - $18.00", "Over $18.00"));

    }

    @Test
    public void searchingByUsingSubCategory() {
        ebayPage.goToMainPage()
                .selectItemsInAdditionalCategory("Video Games & Consoles", "Electronics");
        //System.out.println("====>>"+ebayPage.getWindowTitle().toString());
        Assertions.assertTrue(ebayPage.getWindowTitle().contains("Video Games"),
                String.format("Page Tile should contains $s ", "Video Games"));
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
