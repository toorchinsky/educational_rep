import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProgramTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given().get("/get");
        response.then().statusCode(200);
        response.then().body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void testGetWithParameters() {
        Response response = given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .get("/get");
        response.then().statusCode(200);
        response.then().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
        response.then().body("args.foo1", equalTo("bar1"));
        response.then().body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().body(requestBody).post("/post");
        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
        response.then().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFormData() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .post("/post");
        response.then().statusCode(200);
        response.then().body("url", equalTo("https://postman-echo.com/post"));
        response.then().body("form.foo1", equalTo("bar1"));
        response.then().body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().body(requestBody).put("/put");
        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
        response.then().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().body(requestBody).patch("/patch");
        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
        response.then().body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given().body(requestBody).delete("/delete");
        response.then().statusCode(200);
        response.then().body("data", equalTo(requestBody));
        response.then().body("url", equalTo("https://postman-echo.com/delete"));
    }
}