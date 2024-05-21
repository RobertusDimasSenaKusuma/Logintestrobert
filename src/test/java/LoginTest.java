import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {
    @Test
    public void testLogin() {
        WebDriver driver = driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", "~/firefoxdriver-mac-arm64/firefoxdriver");
        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Products')]"));
        text.isDisplayed();

        String title = driver.getTitle();
        System.out.println(title);

        driver.quit();

    }
}
