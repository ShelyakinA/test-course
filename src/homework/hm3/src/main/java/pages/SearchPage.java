package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchPage {
    private By searchInput = By.cssSelector("#text");
    private By searchButton = By.cssSelector("button");
    private By searchFirstLink = By.cssSelector(".organic__title-wrapper.typo.typo_text_l.typo_line_m");

    private By searchPortal = By.xpath("(//span[@class=\"link__inner\"])[1]");
    private By searchPortalSettings = By.xpath("//a[@aria-label=\"Настройки портала\"]");
    private By searchRussianLanguage = By.xpath("//a[@aria-label=\"Язык\"]");
    private By searchSelectArrow = By.cssSelector(".button_arrow_down");
    private By chooseEnglishLanguage = By.xpath("(//*[text()=\"English\"])[2]");
    private By searchSaveButton = By.xpath("//*[@type=\"submit\"]");
    private By searchEnglishLanguage = By.xpath("//a[@aria-label=\"Language\"]");
    private By pageLanguage = By.xpath("(//span[@class=\"button__text\"])[1]");


    private final WebDriver driver;

    public SearchPage (WebDriver driver) {
    this.driver= driver;
    }

    public void searchElements (String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchButton).click();
    }
    public String getResult() {
        return driver.findElement(searchFirstLink).getText();
    }

    public void searchPortalElements () {
        driver.findElement(searchPortal).click();
        driver.findElement(searchPortalSettings).click();
        driver.findElement(searchRussianLanguage).click();
        driver.findElement(searchSelectArrow).click();
        driver.findElement(chooseEnglishLanguage).click();
        driver.findElement(searchSaveButton).click();
        driver.findElement(searchPortal).click();
        driver.findElement(searchPortalSettings).click();
        driver.findElement(searchEnglishLanguage).click();
    }

    public String getPortalLanguage () {
        return driver.findElement(pageLanguage).getText();
    }
}
