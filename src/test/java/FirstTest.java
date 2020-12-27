import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));
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

    @AfterEach
    public void driverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void navigate() {
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        driver.navigate().to("https://www.nasa.gov/");
        driver.navigate().back();
        String entryURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");
        driver.navigate().forward();
        String entryURL2 = "https://www.nasa.gov/";
        Assertions.assertEquals(entryURL2, driver.getCurrentUrl(), "URL is not correct");

    }
}
