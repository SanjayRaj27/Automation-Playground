package OpsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import PagesUtil.Utilities;
import java.time.Duration;


public class FlipkartSignUpOps {
    //Declare web driver
    public WebDriver driver;
    @BeforeTest
    public void Initializing(){
        driver = Utilities.SetDriver(driver);
    }
    @Test
    public void InitializingSignup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Utilities.CreateAccount(driver).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class=\"_2KpZ6l _2HKlqd _3NgS1a\"]/span")));
        WebElement CA = Utilities.EmailTextBoxCreateAcc(driver);
        CA.click();
        CA.sendKeys("7975260632");
        Utilities.ContinueBtnCreateAcc(driver).click();
        WebElement OTPSentToMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class=\"_2_DUc_ _2GmvEi\"]/span")));
        //WebElement OTPSentToMobile = driver.findElement(By.xpath("//div/a[@class=\"_2_DUc_ _2GmvEi\"]/span"));
        Assert.assertTrue(OTPSentToMobile.isDisplayed());
        System.out.println("Sign in Successfully done");
    }
    @AfterTest
    public void TearDown(){
        driver.close();
    }

}
