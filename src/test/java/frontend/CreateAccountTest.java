import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reportes/createNewAccount.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        CreateAccount createAccount = new CreateAccount(driver, wait);
        createAccount.setUp();
        createAccount.getUrl("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("newAccount")
    @Tag("ALL")
    public void createSavingAccountTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Saving account creation process");
        test.log(Status.INFO, "Inició el test");
        CreateAccount createAccount = new CreateAccount(driver, wait);
        createAccount.writeUserName("peppinitooperez");
        createAccount.writePassword("12345678");
        createAccount.clickLogin();
        createAccount.clickOpenNewAccount();
        createAccount.clickType();
        createAccount.clickSaving();
        createAccount.clickOpenNewAccountButton();
        test.log(Status.PASS, "Account created");
        Assertions.assertEquals(createAccount.getSuccessMessageTitle(),"Account Opened!");
        Assertions.assertEquals(createAccount.getSuccessMessage(),"Congratulations, your account is now open.");
        test.log(Status.PASS, "Congratulations, your account is now open");
    }

    @AfterEach
    public void close() {
        CreateAccount createAccount = new CreateAccount(driver, wait);
        createAccount.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}
