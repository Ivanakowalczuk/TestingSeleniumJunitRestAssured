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

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/Reportes/RegisterTest.html");
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
        Register register = new Register(driver, wait);
        register.setUp();
        register.getUrl("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    @Tag("Register")
    @Tag("ALL")
    public void registerTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Proceso de registro");
        test.log(Status.INFO, "Inicia el Test");
        Register register = new Register(driver, wait);

        try {
            register.clickRegister();
            Assertions.assertEquals(register.getRegisterTitle(), "Signing up is easy!");
            test.log(Status.PASS, "Ingreso a la página de Registro");
            register.writeName("Manzanita");
            register.writeLastName("Perez");
            register.writeAddress("Av 234");
            register.writeCity("Florida");
            register.writeState("US");
            register.writeZipCode("32789");
            register.writePhone("351247895");
            register.writeSsn("123-23-52");
            register.writeUserName("manzanitaperez");
            register.writePassword("12345678");
            register.writeConfirmPassword("12345678");
            test.log(Status.PASS, "Datos de Registro completados");
            register.clickRegisterButton();
            test.log(Status.PASS, "Registro existoso");
            Assertions.assertEquals(register.getSuccessMessage(), "Your account was created successfully. You are now logged in.");
            test.log(Status.PASS, "Mensaje de registro exitoso pasó");

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Error de registro: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void close() {
        Register register = new Register(driver, wait);
        register.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}
