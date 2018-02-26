package pnz.autotest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

public class YandexMarketTest extends BaseTest {

        private static SearchPage searchPage;

        @BeforeClass
        public void beforeTest() throws InterruptedException {
            searchPage = PageFactory.initElements(driver, SearchPage.class);
        }

        @Test
        public void countFindElements() throws InterruptedException {
            driver.get("https://market.yandex.ru");
            searchPage.searchElements("часы");

            Assert.assertEquals(12, searchPage.getAllElements());
        }


        @Test
        public void checkIncreaseIcon() throws InterruptedException {
            driver.get("https://market.yandex.ru");
            searchPage.searchElements("часы");
            searchPage.sortByPriceIncreased();
            Assert.assertTrue(searchPage.increaseIconAttribute().contains("asc"),"Not Increased");
        }

        @Test
        public void checkDecreaseIcon() throws InterruptedException {
            driver.get("https://market.yandex.ru");
            searchPage.searchElements("часы");
            searchPage.sortByPriceDecreased();
            Assert.assertTrue(searchPage.decreaseIconAttribute().contains("desc"),"Not Decreased");
        }
}


