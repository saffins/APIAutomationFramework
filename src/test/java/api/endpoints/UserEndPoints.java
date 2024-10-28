package api.endpoints;


import api.payload.User;
import api.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class UserEndPoints {

    public static Response createUser(User payload){

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> userMap = null;
        try {
            userMap = objectMapper.convertValue(payload, Map.class);
            System.out.println(userMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Response r = RestUtils.performPost(Routes.post_url,userMap);
        return r;

    }

    public static Response readUser(String username){
        Response r =RestUtils.performGet(Routes.get_url,username);
        return r;
    }

    public static Response updateUser(String username){
        Response r =RestUtils.performUpdate(String.format(Routes.update_url,username),username);
        return r;

    }

    public static Response deleteUser(String username){

        Response r =RestUtils.performDelete(Routes.delete_url,username);
        return r;

    }




}
