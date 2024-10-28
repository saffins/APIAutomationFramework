package api.test;
import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OauthExampleTest {

    public static void main(String[] args){


        String response = RestAssured.given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W").
                formParams("grant_type","client_credentials").
                formParams("scope","trust").when().log().all().
                post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

        JsonPath js = new JsonPath(response);
        String accesstoken = js.getString("access_token");

       String res =  RestAssured.given().queryParam("access_token",accesstoken).when().log()
                .all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();

        System.out.println(res);


    }

}
