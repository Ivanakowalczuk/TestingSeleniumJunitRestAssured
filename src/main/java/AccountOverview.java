import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountOverview extends BasePage {
    private By accountOverview = By.xpath("//a[normalize-space()='Accounts Overview']");
    private By textBalance = By.xpath("//td[contains(text(),'*Balance includes deposits that may be subject to ')]");
    private By accountCeldaUno = By.className("ng-binding");
    private By accountOverviewTittle = By.xpath("//h1[normalize-space()='Account Details']");
    private By accountActivityMonth = By.xpath("//select[@id='month']");
    private By allAccountActivityMonth = By.xpath("//select[@id='month']//option[@value='All'][normalize-space()='All']");

    private By type = By.xpath("//select[@id='transactionType']");
    private By allType = By.xpath("//select[@id='transactionType']//option[@value='All'][normalize-space()='All']");
    private By goButton = By.xpath("//input[@value='Go']");

    public AccountOverview(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAccountOverview() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        click(accountOverview);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void clickAccountCeldaUno() throws InterruptedException {
        Thread.sleep(1000);
        click(accountCeldaUno);
    }
    public void clickAccountActivityMonth() throws InterruptedException {
        Thread.sleep(1000);
        click(accountActivityMonth);
    }
    public void clickAccountActivityMonthAll() throws InterruptedException {
        Thread.sleep(1000);
        click(allAccountActivityMonth);
    }
    public void clickType() throws InterruptedException {
        click(type);
    }
    public void clickTypeAll() throws InterruptedException {
        Thread.sleep(1000);
        click(allType);
    }

    public void clickGoButton() throws InterruptedException {
        click(goButton);
    }

    public String getText() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Página de resumen de cuentas: " + getText(textBalance));
        return this.getText(textBalance);
    }
    public String getTitle() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Página de resumen de cuentas: " + getText(accountOverviewTittle));
        return this.getText(accountOverviewTittle);
    }
}
