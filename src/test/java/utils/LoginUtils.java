package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

    public class LoginUtils {

        public static Response loginUser(String userName, String password) {
            String loginUrl = "http://parabank.parasoft.com/parabank/services/bank/login/" + userName + "/" + password;
            return RestAssured.get(loginUrl);
        }
    }


