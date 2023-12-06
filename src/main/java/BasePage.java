import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected By logoImg = By.className("logo");
    protected By registerButon = By.xpath("(//a[normalize-space()='Register'])[1]");
    protected By name = By.xpath("//input[@name='username']");
    protected By password = By.xpath("//input[@name='password']");
    protected By loginButon = By.xpath("//input[@value='Log In']");
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
    }

    public void setUp() {
        driver.manage().window().maximize();
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    protected WebElement elementFind(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void sendText(String input, By locator) throws InterruptedException {
        this.elementFind(locator).clear();
        this.elementFind(locator).sendKeys(input);
    }

    protected void sendKey(CharSequence key, By locator) throws InterruptedException {
        this.elementFind(locator).sendKeys(key);
    }

    protected void click(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.elementFind(locator).click();
    }

    protected String getText(By locator) throws InterruptedException {
        return this.elementFind(locator).getText();
    }

    public void clickRegister() throws InterruptedException {
        Thread.sleep(1000);
        this.click(registerButon);
    }

    public void clickEnLogo() throws InterruptedException {
        this.click(logoImg);
    }

    public void writeUserName(String userName) throws InterruptedException{
        Thread.sleep(1000);
        this.elementFind(name);
        this.sendText(userName, name);
    }
    public void writePassword(String userPassword) throws InterruptedException{
        Thread.sleep(1000);
        this.elementFind(password);
        this.sendText(userPassword, password);
    }

    public void clickLogin() throws InterruptedException {
        this.click(loginButon);
    }

}