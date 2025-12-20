package utils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, String> getJsonDataAsMap(String jsonFileName){
        String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources/"+jsonFileName;

        return mapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});
    }
}
