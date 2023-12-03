import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class transactionsTest {
    @Test
    public void GetAllTransactions() {
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/accounts/15786/transactions/month/All/type/All");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());

    }

}
