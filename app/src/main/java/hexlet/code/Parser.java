package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;


public class Parser {


    public static Map<String, Object> parse(String content, String dataFormat) throws Exception {
        switch (dataFormat) {
            case "yml":
            case "yaml":
                return parseYaml(content);
            case "json":
                return parseJson(content);
            default:
                throw new Exception("Unknown format: '" + dataFormat + "'");
        }

    }

    public static Map parseJson(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        return map;
    }

    public static Map parseYaml(String yaml) throws Exception {
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> map
                = objectMapper.readValue(yaml, new TypeReference<Map<String, Object>>() {});
        return map;
    }

}
