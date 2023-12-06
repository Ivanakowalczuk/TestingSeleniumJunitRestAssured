package backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetTestPageOverview {
    static final String URL = "https://parabank.parasoft.com/parabank/overview.htm";
    @Test
    public void getPageOverview (){
        Response resGet = RestAssured.get(URL);
        String h2Text = resGet.getBody().htmlPath().getString("html.body.div.div.p");
        Assert.assertEquals(h2Text, "Experience the difference© Parasoft. All rights reserved.");
        String title = resGet.getBody().htmlPath().getString("html.head.title");
        Assert.assertEquals(title, "ParaBank | Error");
        System.out.println(resGet.getBody().asString());
    }
}
