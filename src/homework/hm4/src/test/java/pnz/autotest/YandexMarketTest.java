package pnz.autotest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YandexMarketPage;

public class YandexMarketTest extends BaseTest {

    private static YandexMarketPage searchPage;

    @BeforeClass
    public void beforeTest() throws InterruptedException {
        searchPage = PageFactory.initElements(driver, YandexMarketPage.class);
    }

    @Test
    public void countFindElements() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");

        Assert.assertEquals(48, searchPage.getAllElements());
    }


    @Test
    public void checkIncreaseIcon() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");
        searchPage.sortByPriceIncreased();
        Assert.assertTrue(searchPage.increaseIconAttribute().contains("asc"), "Not Increased");
    }

    @Test
    public void checkDecreaseIcon() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");
        searchPage.sortByPriceDecreased();
        Assert.assertTrue(searchPage.decreaseIconAttribute().contains("desc"), "Not Decreased");
    }

    //проверка элементов выводимых при сортировке по возрастанию
    /*@Test
    public void func1() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");
        searchPage.sortByPriceIncreased();
        System.out.println(searchPage.getPriceIntList());
    }*/

    @Test
    public void increasePricesCheck() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");
        searchPage.sortByPriceIncreased();
        Thread.sleep(1000);
        System.out.println(searchPage.getPriceIncreased());
        Assert.assertTrue(searchPage.getPriceIncreased(), "Not Increased");
    }

    @Test
    public void decreasePricesCheck() throws InterruptedException {
        driver.get("https://market.yandex.ru");
        searchPage.searchElements("часы");
        searchPage.sortByPriceDecreased();
        Thread.sleep(2000);
        System.out.println(searchPage.getPriceDecreased());
        Assert.assertTrue(searchPage.getPriceDecreased(), "Not Decreased");
    }


}


