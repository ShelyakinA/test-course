package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private By searchInput = By.cssSelector("#header-search");
    private By findAllElements = By.cssSelector(".n-snippet-card2");

    private By sortByPriceButton = By.xpath("(//*[text()=\"по цене\"])");
    private By findIncreaseIcon = By.xpath("(//a[text()=\"по цене\"])/..");

    private By findProductPrice = By.cssSelector("div[class=\"price\"]");

    private final WebDriver driver;

    public SearchPage (WebDriver driver){
        this.driver = driver;
    }

    public void searchElements (String text) {
        driver.findElement(searchInput).sendKeys(text, Keys.ENTER);
    }
    public int getAllElements () {
        return driver.findElements(findAllElements).size();
    }


    public void sortByPriceIncreased () {
        driver.findElement(sortByPriceButton).click();
    }
    public String increaseIconAttribute (){
        return driver.findElement(findIncreaseIcon).getAttribute("class");
    }

    public void sortByPriceDecreased () {
        driver.findElement(sortByPriceButton).click();
        driver.findElement(sortByPriceButton).click();
    }
    public String decreaseIconAttribute (){
        return driver.findElement(findIncreaseIcon).getAttribute("class");
    }

    public int checkProductPrice () {
        List<WebElement> listOfProductPrices = driver.findElements(findProductPrice);
        int [] arr = new int [12];

        return ;
    }
}
