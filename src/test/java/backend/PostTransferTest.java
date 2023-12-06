package backend;

import backend.utils.AccountsUtils;
import backend.utils.LoginUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostTransferTest {
    @Test
    public void PostTransfer() {
        String userName = "pipi";
        String password = "Pepa234";
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("El usuario está logueado, código obtenido: " + loginResponse.statusCode());
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountsUtils.getAccountsForUser(customerId);
        String fromAccountId =  accountsResponse.path("accounts.account[1].id");
        String toAccountId =  accountsResponse.path("accounts.account[2].id");
        String baseUrl = "https://parabank.parasoft.com/parabank/services/bank";
        String endpoint = "/transfer";
        int amount = 10;
        String url = baseUrl + endpoint + "?" + "fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=" + amount;
        String responseBody = given()
                .post(url)
                .then()
                .statusCode(200)
                .extract().body().asString();
        System.out.println("Response Body: " + responseBody);

    }
}
