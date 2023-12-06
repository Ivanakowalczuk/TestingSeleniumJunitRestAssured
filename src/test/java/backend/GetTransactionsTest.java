package backend;

import backend.utils.AccountsUtils;
import backend.utils.LoginUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class GetTransactionsTest {
    @Test
    public void GetAllTransactions() {
        String userName = "pipi";
        String password = "Pepa234";
        Response loginResponse = LoginUtils.loginUser(userName, password);
        System.out.println("El usuario está logueado, código obtenido: " + loginResponse.statusCode());
        String customerId = loginResponse.path("customer.id");
        Response accountsResponse = AccountsUtils.getAccountsForUser(customerId);
        String account =  accountsResponse.path("accounts.account[1].id");
        Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/accounts/" + account + "/transactions/month/All/type/All");
        Assert.assertEquals(resGet.statusCode(), 200);
        Assert.assertEquals(resGet.body().xmlPath().getString("transactions.transaction.description[0]"), "Funds Transfer Received");
        Assert.assertEquals(resGet.body().xmlPath().getString("transactions.transaction.accountId[0]"), "32436");
        Assert.assertEquals(resGet.body().xmlPath().getString("transactions.transaction.amount[0]"), "100.00");

        System.out.println("El código obtenido es: " + resGet.statusCode());
        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
        System.out.println(resGet.getBody().asString());


    }
}
