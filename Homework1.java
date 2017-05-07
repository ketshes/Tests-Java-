import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 07.05.17.
 */
public class Homework1 {

    @Test
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/yuriy/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        // WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("region_653240")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("сфинкс");
        driver.findElement(By.cssSelector("span.suggest-category.js-suggest-category")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.close();


    }
}
