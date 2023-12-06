import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends BasePage{
    private By title = By.xpath("//h1[normalize-space()='Signing up is easy!']");
    private By firstName = By.xpath("//input[@id='customer.firstName']");
    private By lastName = By.xpath("//input[@id='customer.lastName']");
    private By address = By.xpath("//input[@id='customer.address.street']");
    private By city = By.xpath("//input[@id='customer.address.city']");
    private By state = By.xpath("//input[@id='customer.address.state']");
    private By zipCode = By.xpath("//input[@id='customer.address.zipCode']");
    private By phone = By.xpath("//input[@id='customer.phoneNumber']");
    private By ssn = By.xpath("//input[@id='customer.ssn']");
    private By userName = By.xpath("//input[@id='customer.username']");
    private By password = By.xpath("//input[@id='customer.password']");
    private By confirmPassword = By.xpath("//input[@id='repeatedPassword']");
    private By registerButon = By.xpath("//input[@value='Register']");
    private By successMessage = By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]");


    public Register(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getRegisterTitle() throws InterruptedException {
        System.out.println("Página de Registro cargada: " + getText(title));
        return this.getText(title);
    }

    public void writeName(String firstNameP) throws InterruptedException {
        sendText(firstNameP, firstName);
    }

    public void writeLastName(String lastNameP) throws InterruptedException {
        sendText(lastNameP, lastName);
    }

    public void writeAddress(String addressP) throws InterruptedException {
        sendText(addressP, address);
    }

    public void writeCity(String cityP) throws InterruptedException {
        sendText(cityP, city);
    }

    public void writeState(String stateP) throws InterruptedException {
        sendText(stateP, state);
    }

    public void writeZipCode(String stateP) throws InterruptedException {
        sendText(stateP, zipCode);
    }
    public void writePhone(String phoneP) throws InterruptedException {
        sendText(phoneP, phone);
    }

    public void writeSsn(String ssnP) throws InterruptedException {
        sendText(ssnP, ssn);
    }

    public void writeUserName(String userNameP) throws InterruptedException {
        sendText(userNameP, userName);
    }

    public void writePassword(String passwordP) throws InterruptedException {
        sendText(passwordP, password);
    }

    public void writeConfirmPassword(String confirmPasswordP) throws InterruptedException {
        sendText(confirmPasswordP, confirmPassword);
    }

    public void clickRegisterButton() throws InterruptedException {
        Thread.sleep(1000);
        click(registerButon);
    }

    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Se creò la cuenta: " + getText(successMessage));
        return this.getText(successMessage);
    }


}
