import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void demoTest() {

        driver.get("http://google.pl");

        /*driver.navigate().to("http://google.pl");
        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj']"));
        String searchEntry = "Volvo s60";
        String title = "Volvo S60 – Wikipedia, wolna encyklopedia";

        searchField.sendKeys(searchEntry);
        searchField.submit();
        driver.findElement(By.xpath(".//*[text()='"+title+"']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(title));

        String entryURL = "https://pl.wikipedia.org/wiki/Volvo_S60";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");*/
    }

    /*@AfterEach
    public void driverQuit() {
        //driver.close();
        //driver.quit();
    }*/

    @Test
    public void navigate() throws InterruptedException, AWTException {
        driver.get("https://www.lambdatest.com/pricing");
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        Actions ac = new Actions(driver);
        WebElement wb = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div/div[2]/div[2]/div[1]/div/div/div[3]/p"));
        ac.moveToElement(wb).build().perform();
        Thread.sleep(3000);
        WebElement plan = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/button"));
        plan.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='4 Parallel Tests (25 Users)']")).click();
        Thread.sleep(4000);
        driver.quit();
    }
}
