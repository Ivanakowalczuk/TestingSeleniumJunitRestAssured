package backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetTestPageRegister {
    static final String URL = "https://parabank.parasoft.com/parabank/register.htm";
    @Test
    public void getPageRegister (){
        Response resGet = RestAssured.get(URL);
        Integer codigoEstatus = resGet.getStatusCode();
        Assert.assertEquals(resGet.statusCode(), 200);
        System.out.println("El estatus de respuesta es: " + codigoEstatus);

    }
}
