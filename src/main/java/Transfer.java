import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transfer extends BasePage {
    private By linkTransfer = By.xpath("//a[normalize-space()='Transfer Funds']");
    private By title = By.xpath("//h1[normalize-space()='Transfer Funds']");
    private By amount = By.id("amount");
    private By fromAccountId = By.id("fromAccountId");
    private By numberFromAccountId = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    private By toAccountId = By.id("toAccountId");
    private By numberToAccountId = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By transferButton =By.xpath("//input[@value='Transfer']");
    private By succesMessageTransfer = By.xpath("//h1[normalize-space()='Transfer Complete!']");

    public Transfer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void writeAmount(String amountP) throws InterruptedException {
        sendText(amountP, amount);
    }
    public void clickFromAccountId() throws InterruptedException {
        click(fromAccountId);
    }
    public void clickNumberFromAccountId() throws InterruptedException {
        click(numberFromAccountId);
    }
    public void clickToAccountId() throws InterruptedException {
        click(toAccountId);
    }
    public void clickNumberToAccountId() throws InterruptedException {
        click(numberToAccountId);
    }

    public void clickLinkTransfer() {
        try {
            click(linkTransfer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickTransferButton() throws InterruptedException {
        click(transferButton);
    }

    public String getTittle() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Mensaje titulo: " + getText(title));
        return this.getText(title);
    }
    public String getSuccesMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Mensaje de transferencia exitosa: " + getText(succesMessageTransfer));
        return this.getText(succesMessageTransfer);
    }
}
