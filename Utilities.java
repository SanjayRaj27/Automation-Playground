package PagesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Utilities {
    private static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement element = null;

    public static WebDriver SetDriver(WebDriver driver) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        return driver;
    }
    public static WebElement HOMEPAGE(WebDriver driver) {
        element = driver.findElement(By.xpath("//img[@title=\"Flipkart\"]"));
        return element;
    }

    public static WebElement FLPOTPBUTTON(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='_1wGnMD rX1XT4 _2nD2xJ']"));
        return element;
    }

    public static WebElement EMAILTEXTBOX(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@class='_18u87m _3WuvDp']"));
        return element;
    }
    public static WebElement CreateAccount(WebDriver driver){
        element = driver.findElement(By.xpath("//div/a[@class=\"_1O7q6e\"]"));
        return element;
    }
    public static WebElement EmailTextBoxCreateAcc(WebDriver driver){
        element = driver.findElement(By.xpath("//div/form/div/input[@class=\"_2IX_2- VJZDxU\"]"));
        return element;
    }
    public static WebElement ContinueBtnCreateAcc(WebDriver driver){
        element = driver.findElement(By.xpath("//div/button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]/span"));
        return element;
    }
    public static WebElement CloseLoginWindowX(WebDriver driver){
        element = driver.findElement(By.xpath("//div/div[@class=\"JFPqaw\"]/span"));
        return element;
    }
    public static WebElement Electronics(WebDriver driver){
        element = driver.findElement(By.xpath("//div/div/div[@class='_1ch8e_'][2]"));
        return element;
    }
    public static WebElement LabelFilterInElecDept(WebDriver driver){
        element = driver.findElement(By.xpath("//div/div/div/div[@class=\"_1KOcBL\"]/section/div/div[@class=\"_3V8rao\"]/span"));
        return element;
    }
    public static void ScrollUntilElementFound(String xpath){
        element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].ScrollUntilElementFound(true)", element);
    }
    public static void ElementFoundAssertion(String xpath){
        element = driver.findElement(By.xpath(xpath));
        Assert.assertTrue(element.isDisplayed());
    }
    public static void ElementTextFinder(String xpath){
        element = driver.findElement(By.xpath(xpath));
        element.getText();
    }
    public static WebElement ClickOnElement(String xpath){
        element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }
    public static void ClickOnMultipleCheckBoxes(WebDriver driver, int n, String xpath){
        java.util.List<WebElement> checkboxes = driver.findElements(By.xpath(xpath));
        System.out.println(checkboxes);
        for (int i = 0; i < Math.min(n, checkboxes.size()); i++){
            checkboxes.get(i).click();
    }
    }
}

