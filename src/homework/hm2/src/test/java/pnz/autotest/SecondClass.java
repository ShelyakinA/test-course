package pnz.autotest;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class SecondClass {

        private static WebDriver driver;


        @BeforeClass
        public static void setup(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://yandex.ru/");

        }


        @Test
        public void search(){

            WebElement searchAndClick = driver.findElement(By.xpath("(//span[@class=\"link__inner\"])[1]"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.xpath("//a[@aria-label=\"Настройки портала\"]"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.xpath("//a[@aria-label=\"Язык\"]"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.cssSelector(".button_arrow_down"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.xpath("(//*[text()=\"English\"])[2]"));
            searchAndClick.click();

            WebElement saveButton = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
            saveButton.click();

            searchAndClick = driver.findElement(By.xpath("(//span[@class=\"link__inner\"])[1]"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.xpath("//a[@aria-label=\"Настройки портала\"]"));
            searchAndClick.click();
            searchAndClick = driver.findElement(By.xpath("//a[@aria-label=\"Language\"]"));
            searchAndClick.click();

            WebElement resultSettings = driver.findElement(By.xpath("(//span[@class=\"button__text\"])[1]"));
            String result = resultSettings.getText();
            Assert.assertEquals("English", result);
        }


        @AfterClass
        public static void qiut(){
            driver.quit();
        }

}
