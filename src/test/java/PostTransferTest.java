import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.LoginUtils;

import static io.restassured.RestAssured.given;


public class PostTransferTest {
    @Test
    public void PostTransfer() {
        String userName = "juanapepa";
        String password = "Juana123";
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("El usuario está logueado, código obtenido: " + loginResponse.statusCode());

        String baseUrl = "https://parabank.parasoft.com/parabank/services/bank";
        String endpoint = "/transfer";
        int fromAccountId = 15342;
        int toAccountId = 15231;
        int amount = 15;
        String url = baseUrl + endpoint + "?" + "fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=" + amount;
        String responseBody = given()
                .post(url)
                .then()
                .statusCode(200)
                .extract().body().asString();
        System.out.println("Response Body: " + responseBody);

    }
}
