import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.AccountsUtils;
import utils.LoginUtils;

import static io.restassured.RestAssured.given;

public class GetTransactionsTest {
    @Test
    public void GetAllTransactions() {
        String userName = "juanapepa";
        String password = "Juana123";
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("El usuario está logueado, código obtenido: " + loginResponse.statusCode());
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountsUtils.getAccountsForUser(customerId);
        String account =  accountsResponse.path("accounts.account[1].id");
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/accounts/" + account + "/transactions/month/All/type/All");
        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());

    }

}
