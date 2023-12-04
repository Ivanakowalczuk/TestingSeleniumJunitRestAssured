import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.AccountsUtils;
import utils.LoginUtils;

import static io.restassured.RestAssured.given;

public class PostCreateAccountTest {

    @Test
    public void PostCreateAccount() {
        String userName = "juanapepa";
        String password = "Juana123";
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("El usuario está logueado, código obtenido: " + loginResponse.statusCode());
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountsUtils.getAccountsForUser(customerId);
        String fromAccountId =  accountsResponse.path("accounts.account[0].id");
        String urlBase = "https://parabank.parasoft.com/parabank/services/bank";
        String endpoint = "/createAccount";
        int newAccountType = 1;
             given()
                .contentType("application/json")
                .when().post(urlBase + endpoint + "?customerId=" + customerId + "&newAccountType="+ newAccountType +"&fromAccountId="+ fromAccountId)
                .then().statusCode(200)
                .log().status()
                .log().body();
    }



}
