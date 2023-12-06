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


public class AccountOverviewTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reportes/AccountOverviewTest.html");
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
        AccountOverview accountOverview = new AccountOverview(driver, wait);
        accountOverview.setUp();
        accountOverview.getUrl("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    @Tag("details")
    @Tag("ALL")
    public void AccountOverviewTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Actividad de la cuenta");
        test.log(Status.INFO, "Inicia el Test");
        AccountOverview accountOverview = new AccountOverview(driver, wait);

        try {
            accountOverview.writeUserName("peppinitooperez");
            accountOverview.writePassword("12345678");
            accountOverview.clickLogin();
            accountOverview.clickAccountOverview();
            test.log(Status.PASS, "Ingreso a la página actividad de la cuenta");
            Assertions.assertEquals(accountOverview.getText(), "*Balance includes deposits that may be subject to holds");
            accountOverview.clickAccountCeldaUno();
            accountOverview.clickAccountActivityMonth();
            accountOverview.clickAccountActivityMonthAll();
            accountOverview.clickType();
            accountOverview.clickTypeAll();
            accountOverview.clickGoButton();
            test.log(Status.PASS, "Se completaron los datos");
            Assertions.assertEquals(accountOverview.getTitle(), "Account Details");
            test.log(Status.PASS, "Se ha realizado la transferencia correctamente");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Error: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void close() {
       AccountOverview accountOverview = new AccountOverview(driver, wait);
        accountOverview.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}
