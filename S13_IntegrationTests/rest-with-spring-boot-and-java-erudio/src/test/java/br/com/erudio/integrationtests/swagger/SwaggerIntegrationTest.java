package br.com.erudio.integrationtests.swagger;


import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void shouldDisplaySwaggerUiPage() {
        
        var contentAsString =
                given()
                    .basePath("/swagger-ui/index.html")
                    .port(8888)
                    .when()
                        .get()
                    .then()
                        .statusCode(200)
                    .extract()
                    .body()
                        .asString();
        
        Assertions.assertTrue(contentAsString.contains("Swagger UI"));
    }
}
