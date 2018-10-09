package Selenium.etsy;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;

public class EstyComEmptyCardTest extends EtsyBase {
    private static final String SHOPPING_CARD_ICON = ".etsy-icon-cart";
    private final String PRIVACY_POLICY_FORM = ".alert";
    private static final String MAIN_PAGE = "https://www.etsy.com";

    @Test
    public void shouldHaveEmptyShoppingCardOnFirstVisit() {
        wb.get(MAIN_PAGE);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //privacy rules
       /* WebElement acceptPrivacyRules = wb.findElement(By.cssSelector(PRIVACY_POLICY_FORM))
                .findElement(By.xpath(""));
        acceptPrivacyRules.click();
        */
      /* wb.findElement(By.cssSelector(SHOPPING_CARD_ICON)).click();
       new WebDriverWait(wb, 20).until(webDriver -> webDriver
       .findElement(By.xpath("//*[@id=\"newempty\"]/div/h2")));
       boolean shippingCardHasNoElements = wb.findElements(By.xpath("jkj"));
        assertThat(shippingCardHasNoElements, is(true));
       //find label
*/


    }
}
