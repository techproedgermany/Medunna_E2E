package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utilities.AuthenticationMedunna.generateToken;

public class Medunna_BaseUrl {

        protected static RequestSpecification spec;

        public static void setUp() {
            String baseUrl = "https://medunna.com/api";
            spec = new RequestSpecBuilder().setBaseUri(baseUrl).addHeader("Authorization", "Bearer " + generateToken()).setContentType(ContentType.JSON).build();
        }
    }

