package Selenium.Ebay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EbayComPageObject extends BasePageObject {

    private static final String SEARCH_FIELD = "#gh-ac";
    private static final String SHOP_BY_PRICE_ITEMS = "//nav[@role = 'navigation']//li//div";
    private static final String AUCTION_BUTTON = "//*[@id=\"cbelm\"]/div[1]/div[2]/a[1]";
    private final String mainAddress = "http://www.ebay.com";

    @FindBy(id = "gh-ac")
    private WebElement searchFieldElement;

    public EbayComPageObject(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public EbayComPageObject goToMainPage() {
        webDriver.get(mainAddress);
        return this;
    }

    public EbayComPageObject searchFor(String item) {
        enterCriteriaToSearchField(item);
        return this;
    }

    private void enterCriteriaToSearchField(String item) {
        // WebElement searchField = getSearchField();

        WebElement searchField;
        searchField = searchFieldElement;
        searchField.clear();
        searchField.sendKeys(item);
        searchField.submit();
    }

    private WebElement getSearchField() {
        return findElementIsWait(By.cssSelector(SEARCH_FIELD));
    }

    public EbayComPageObject selectAuction() {
        selectAuctionItemsOption();
        return this;
    }

    private void selectAuctionItemsOption() {
        findElementIsWait(By.xpath(AUCTION_BUTTON)).click();
    }

    public List<String> getAuctionBestPrices() {
        return webDriver.findElements(By.xpath(SHOP_BY_PRICE_ITEMS)).stream()
                .map(webElement -> webElement.getText())
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public EbayComPageObject selectItemsInAdditionalCategory(String subCategory, String category) {
        Actions builder = new Actions(webDriver);
        String xpathSelCategory = String.format("//td[@role = 'listitem']/a[contains(text(), '%s')]", category);
        String xpathSelSubCategory = String.format("//a[contains(text(), '%s')]", subCategory);

        WebElement categoryItem = webDriver.findElement(By.xpath(xpathSelCategory));
        Action ourComplexAction = builder.moveToElement(categoryItem).build();
        ourComplexAction.perform();

        WebElement subCategoryItem = findElementIsWait(By.xpath(xpathSelSubCategory));
        ourComplexAction = builder.moveToElement(subCategoryItem).click().build();
        ourComplexAction.perform();

        return this;
    }

    public String getWindowTitle() {
       return webDriver.getTitle();
    }
}
