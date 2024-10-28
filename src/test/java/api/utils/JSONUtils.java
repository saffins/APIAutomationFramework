package api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JSONUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resou/airlines/qa/"+jsonFileName;
        Map<String,Object> dt = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});
        return dt;

    }

    public static String getJsonDataAsString(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources/"+jsonFileName;
        String dt = new String(Files.readAllBytes(Paths.get(completeJsonFilePath)));
        return dt;

    }


}
