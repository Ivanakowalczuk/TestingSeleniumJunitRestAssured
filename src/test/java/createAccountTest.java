import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class createAccountTest {

    @Test
    public void PostCreateAccount() {
             given()
                .contentType("application/json")
                .when().post("https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=13655&newAccountType=1&fromAccountId=15786")
                .then().statusCode(200)
                .log().status()
                .log().body();
    }



}
