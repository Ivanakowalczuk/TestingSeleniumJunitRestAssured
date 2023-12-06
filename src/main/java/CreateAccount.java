import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount extends BasePage{
    private By openNewAccount = By.xpath("//a[normalize-space()='Open New Account']");
    private By type = By.xpath("//select[@id='type']");
    private By savingAccount = By.xpath("//*[@id=\"type\"]/option[2]");
    private By openNewAccountButton = By.xpath("//input[@value='Open New Account']");
    private By titleSuccessMessage = By.xpath("//h1[normalize-space()='Account Opened!']");
    private By successMessage = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");


    public CreateAccount(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOpenNewAccount() throws InterruptedException {
        Thread.sleep(1000);
        click(openNewAccount);

    }

    public void clickType() throws InterruptedException {
        click(type);
    }

    public void clickSaving() throws InterruptedException {
        click(savingAccount);

    }

    public void clickOpenNewAccountButton() throws InterruptedException {
        Thread.sleep(1000);
        click(openNewAccountButton);


    }

    public String getSuccessMessageTitle() throws InterruptedException {
        System.out.println("Create Account: " + getText(titleSuccessMessage));
        return this.getText(titleSuccessMessage);
    }

    public String getSuccessMessage() throws InterruptedException {
        System.out.println("Create Account: " + getText(successMessage));
        return this.getText(successMessage);
    }

}
