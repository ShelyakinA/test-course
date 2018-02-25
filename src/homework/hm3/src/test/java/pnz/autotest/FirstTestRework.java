package pnz.autotest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

public class FirstTestRework extends BaseTest {

    private static SearchPage searchPage;

    @BeforeClass
    public void beforeTest() throws InterruptedException {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test
    public void enterAndAssertData () throws InterruptedException {
        driver.get("https://ya.ru/");
        searchPage.searchElements("погода пенза");

        Assert.assertEquals("Погода в Пензе", searchPage.getResult());
    }

    @Test
    public void portalChangeLanguageCheck() throws InterruptedException{
        driver.get("https://yandex.ru");
        searchPage.searchPortalElements();

        Assert.assertEquals("English" , searchPage.getPortalLanguage());

    }
}

