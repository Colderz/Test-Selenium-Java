import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    @Test
    public void demoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 730));

        driver.navigate().to("http://google.pl");
        WebElement searchField = driver.findElement(By.cssSelector("[title='Szukaj']"));
        String searchEntry = "Volvo s60";
        String title = "Volvo S60 – Wikipedia, wolna encyklopedia";

        searchField.sendKeys(searchEntry);
        searchField.submit();
        driver.findElement(By.xpath(".//*[text()='"+title+"']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs(title));

        String entryURL = "https://pl.wikipedia.org/wiki/Volvo_S60";
        Assertions.assertEquals(entryURL, driver.getCurrentUrl(), "URL is not correct");

        driver.quit();
    }
}
