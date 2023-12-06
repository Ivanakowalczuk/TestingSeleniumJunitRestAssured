import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransferTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reportes/TransferTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Transfer transfer = new Transfer(driver, wait);
        transfer.setUp();
        transfer.getUrl("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("Transfer")
    @Tag("ALL")
    public void AccountOverviewTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de transferencia Exitoso");
        test.log(Status.INFO, "Inicia el Test");
        Transfer transfer = new Transfer(driver, wait);

        try {
            transfer.writeUserName("peppinitooperez");
            transfer.writePassword("12345678");
            transfer.clickLogin();
            transfer.clickLinkTransfer();
            test.log(Status.PASS, "Ingreso a la página de transferencia");
            Assertions.assertEquals(transfer.getTittle(), "Transfer Funds");
            transfer.writeAmount("10");
            transfer.clickFromAccountId();
            transfer.clickNumberFromAccountId();
            transfer.clickToAccountId();
            transfer.clickNumberToAccountId();
            transfer.clickTransferButton();
            test.log(Status.PASS, "Se completaron los datos de las cuentas y el monto");
            Assertions.assertEquals(transfer.getSuccesMessage(), "Transfer Complete!");
            test.log(Status.PASS, "Se ha realizado la transferencia");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Error: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void close() {
        Transfer transfer = new Transfer(driver, wait);
        transfer.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}
