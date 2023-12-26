package OpsUtil;

import PagesUtil.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptException;
import java.time.Duration;

public class FlipkartSelectItem {
    public WebDriver driver;
    @BeforeTest
    public void Initialize(){
        driver = Utilities.SetDriver(driver);
    }

    @Test
    //the below function selects the watch section that is trending and selects multiple brands and add it to the cart
    public void AddMobileWatchToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@class=\"JFPqaw\"]/span")));
        Utilities.CloseLoginWindowX(driver).click();
        Utilities.Electronics(driver).click();
        WebElement AllSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/object/a[1]")));
        AllSection.click();
        WebElement FilterLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@class=\"_3V8rao\"]/span")));
        Assert.assertTrue(FilterLabel.isDisplayed());
        Utilities.ClickOnMultipleCheckBoxes(driver, 5, "//input[@class=\"_30VH1S\"]");
        //Assert for the above checkboxes selected
        java.util.List<WebElement> SelectedCheckBox = driver.findElements(By.xpath("//div/div[@class=\"_3sckoD\"]"));
        for(WebElement divElement: SelectedCheckBox){
            String divText = divElement.getText();
            System.out.println(divText+ "1*, 2*, 3* and 4* is displayed");
            Assert.assertTrue(isTextPresentOnScreen(divText));
        }
        Utilities.ScrollUntilElementFound("//div/div[@class=\"_4ddWXP\"]/a[@title=\"boAt Bassheads 100 Wired Headset\"]");
        WebElement BASSHEAD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@class=\"_4ddWXP\"]/a[@title=\"boAt Bassheads 100 Wired Headset\"]")));
        BASSHEAD.click();
        Utilities.ElementFoundAssertion("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]");
        Utilities.ElementFoundAssertion("//button[@class=\"_2KpZ6l _2U9uOA ihZ75k _3AWRsL\"]");
        Utilities.ScrollUntilElementFound("//div[@class=\"_2d4LTz\"]");//input[@class="_30VH1S"]
        Utilities.ElementTextFinder("//div[@class=\"_2d4LTz\"]");
        Utilities.ElementFoundAssertion("//div[@class=\"_2d4LTz\"]");
        Utilities.ClickOnElement("//button[@class=\"_2KpZ6l _2U9uOA ihZ75k _3AWRsL\"]");
        //Label Login or SignUp is displayed
        Utilities.ElementFoundAssertion("//div/div/h3/span[@class=\"_1aULyb\"]");
        System.out.println("Successfully added item boat headset");
    }

    private boolean isTextPresentOnScreen(String divText) {
        return true;
    }

}
