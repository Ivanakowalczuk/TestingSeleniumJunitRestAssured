import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class transferTest {
    @Test
    public void PostTransfer() {
        given()
                .contentType("application/json")
                .when().post("https://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=15786&toAccountId=18894&amount=1")
                .then().statusCode(200)
                .log().status()
                .log().body();
    }
}
