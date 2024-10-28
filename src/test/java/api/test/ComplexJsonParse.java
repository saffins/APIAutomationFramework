package api.test;

import api.utils.JSONUtils;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

public class ComplexJsonParse {

    public static void main(String[] args) {
    String data="";
        try {
           data= JSONUtils.getJsonDataAsString("compJSON.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        JsonPath path =new JsonPath(data);
        System.out.println(path.getString("dashboard.size()"));
        System.out.println(path.getString("dashboard.purchaseAmount"));
        int count = path.getInt("courses.size()");

        for(int i =0;i<count ;i++){
            System.out.println(path.getString("courses["+i+"].title"));
        }







    }

}
