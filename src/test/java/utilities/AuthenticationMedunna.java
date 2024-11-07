package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {


    public static String generateToken(){
        String credentials = "{\n" +
                "  \"password\": \"Techpro123.\",\n" +
                "  \"rememberMe\": false,\n" +
                "  \"username\": \"techproed\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON).body(credentials).post("https://medunna.com/api/authenticate");
        return response.jsonPath().getString("id_token");
    }
}
