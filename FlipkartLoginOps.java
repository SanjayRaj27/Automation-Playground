package OpsUtil;
//AUTOMATION FOR FLIPKART WEBSITE
//USER AUTHENTICATION
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import PagesUtil.Utilities;

public class FlipkartLoginOps {
    public WebDriver driver;
    @BeforeTest
    public void Initializing() {
        driver = Utilities.SetDriver(driver);
    }
    @Test
    public void InteractionsLOGIN() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Utilities.EMAILTEXTBOX(driver).click();
        System.out.println("Clicked on TextBox");
        Utilities.EMAILTEXTBOX(driver).sendKeys("sanjaysansb2706@gmail.com");
        Utilities.FLPOTPBUTTON(driver).click();
        System.out.println("Clicked on Request OTP");
        WebElement Human = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[@class='oaLOM5']")));
        Assert.assertTrue(Human.isDisplayed());
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
