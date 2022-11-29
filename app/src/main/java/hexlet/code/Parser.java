package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static Map jsonToMap(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() { });
        return map;
    }

    public static Map yamlToMap(String yaml) throws Exception {
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> map
                = objectMapper.readValue(yaml, new TypeReference<Map<String, Object>>() { });
        return map;
    }

    public static Map parse(String pathToFile) throws Exception {
        // Формируем путь абсолютный путь,
        // если filePath будет содержать относительный путь,
        // то мы всегда будет работать с абсолютным
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

//     Проверяем существование файла
        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exist");
        }
        // Читаем файл
        String readFile = Files.readString(path);




        String fileType = Files.probeContentType(path);
//        if (fileType == null) {
//            fileType = "application/x-yaml";
//        }

        if (Objects.equals(fileType, "application/json")) {
            return jsonToMap(readFile);
        } else if (Objects.equals(fileType,"application/x-yaml")) {
            return yamlToMap(readFile);
        } else {
            throw new Exception("File type'" + fileType + "' not supported" + "Please, select .json or .yml file");
        }

    }


}
