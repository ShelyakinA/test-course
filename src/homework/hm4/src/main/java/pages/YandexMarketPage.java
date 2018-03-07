package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class YandexMarketPage {

    private By searchInput = By.cssSelector("#header-search");
    private By findAllElements = By.cssSelector(".n-snippet-card2");

    private By sortByPriceButton = By.xpath("(//*[text()=\"по цене\"])");
    private By findIncreaseIcon = By.xpath("(//a[text()=\"по цене\"])/..");

    private By findProductPrice = By.cssSelector("div[class*=\"main-price\"] div");

    private final WebDriver driver;

    public YandexMarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchElements(String text) {
        driver.findElement(searchInput).sendKeys(text, Keys.ENTER);
    }
    public int getAllElements() {
        return driver.findElements(findAllElements).size();
    }


    public void sortByPriceIncreased() {
        driver.findElement(sortByPriceButton).click();
    }
    public String increaseIconAttribute() {
        return driver.findElement(findIncreaseIcon).getAttribute("class");
    }



    public void sortByPriceDecreased() {
        driver.findElement(sortByPriceButton).click();
        driver.findElement(sortByPriceButton).click();
    }
    public String decreaseIconAttribute() {
        return driver.findElement(findIncreaseIcon).getAttribute("class");
    }

    //формирование списка с ценами, для проверки вывода
    /*
    public ArrayList<Integer> getPriceIntList () throws InterruptedException {
        driver.navigate().refresh();
        List<WebElement> prices = driver.findElements(findProductPrice);
        ArrayList<Integer> pricesInt = new ArrayList<Integer>();
        int counter = 0;
        while (counter < prices.size()){
            String elementPrice = prices.get(counter).getText().replace(" ", "" );
            elementPrice = elementPrice.substring(0,elementPrice.length() - 1);
            pricesInt.add(counter , Integer.parseInt(elementPrice));
            counter++;
            //System.out.println(pricesInt);
        }
        return pricesInt;
    }*/

    public Boolean getPriceIncreased() throws InterruptedException{
        List<WebElement> prices = driver.findElements(findProductPrice);
        int counter = 0;
        boolean result = false;
        while  (counter < prices.size()){
            String previousChoosenElement = prices.get(counter).getText().replace(" ","");
            previousChoosenElement = previousChoosenElement.substring(0 , previousChoosenElement.length() -  1);
            Integer previousChoosenElementtInt = Integer.parseInt(previousChoosenElement);

            String nextsChoosenElement = prices.get(counter + 1).getText().replace(" ","");
            nextsChoosenElement = nextsChoosenElement.substring(0, nextsChoosenElement.length() - 1);
            Integer nextsChoosenElementInt = Integer.parseInt(nextsChoosenElement);

            if (previousChoosenElementtInt <= nextsChoosenElementInt){
                result = true;
                counter++;
            } else {
                result = false;
                break;
            }
            counter++;
        }
        return result;
    }

    public Boolean getPriceDecreased() throws InterruptedException{
        List<WebElement> prices = driver.findElements(findProductPrice);
        int counter = 0;
        boolean result = false;
        while  (counter < prices.size()){
            String previousChoosenElement = prices.get(counter).getText().replace(" ","");
            previousChoosenElement = previousChoosenElement.substring(0 , previousChoosenElement.length() -  1);
            Integer previousChoosenElementtInt = Integer.parseInt(previousChoosenElement);

            String nextsChoosenElement = prices.get(counter + 1).getText().replace(" ","");
            nextsChoosenElement = nextsChoosenElement.substring(0, nextsChoosenElement.length() - 1);
            Integer nextsChoosenElementInt = Integer.parseInt(nextsChoosenElement);

            if (previousChoosenElementtInt >= nextsChoosenElementInt){
                result = true;
                counter++;
            } else {
                result = false;
                break;
            }
            counter++;
        }
        return result;
    }

}
