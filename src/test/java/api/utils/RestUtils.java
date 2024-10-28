package api.utils;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static Response performPost(String endpoint, Map<String,Object> reqPayload){
        return RestAssured.given().log().all().baseUri(Routes.base_url).contentType(ContentType.JSON).
                body(reqPayload).post(endpoint).then().log().all().extract().response();

    }

    public static Response performGet(String endpoint, String param){
        return RestAssured.given().log().all().baseUri(Routes.base_url).contentType(ContentType.JSON).
                pathParam("username",param).get(endpoint).then().log().all().extract().response();

    }

    public static Response performUpdate(String endpoint, String param){
        return RestAssured.given().log().all().baseUri(Routes.base_url).contentType(ContentType.JSON).put(endpoint).then().log().all().extract().response();

    }

    public static Response performDelete(String endpoint, String param){
        return RestAssured.given().log().all().baseUri(Routes.base_url).contentType(ContentType.JSON).
                pathParam("username",param).delete(endpoint).then().log().all().extract().response();

    }


}
