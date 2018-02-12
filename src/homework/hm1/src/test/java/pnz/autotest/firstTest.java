package pnz.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class firstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru");
    }


    @Test
    public void enterData(){
        WebElement findInput = driver.findElement(By.cssSelector("#text"));
        findInput.sendKeys("погода пенза");

        WebElement button = driver.findElement(By.cssSelector("button"));
        button.click();

        WebElement href = driver.findElement(By.cssSelector(".organic__title-wrapper.typo.typo_text_l.typo_line_m"));
        String result = href.getText();

        Assert.assertEquals("Погода в Пензе",result );
    }

    @AfterClass
    public static void quit(){
        driver.quit();
    }
}
