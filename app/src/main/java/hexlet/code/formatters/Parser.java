package hexlet.code.formatters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class Parser {
    public static Map readFileAndFormat(String pathToFile) throws Exception {
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
        if (readFile.isEmpty()) {
            readFile = "{}";
        }

        String fileType = FilenameUtils.getExtension(pathToFile);

        Map<String, String> filetypeAndFile = Map.of(fileType, readFile);
        return filetypeAndFile;
    }

    public static Map<String, Object> parse(Map<String, String> filetypeAndFile) throws Exception {
        Set<String> fileType = filetypeAndFile.keySet();
        for (String type : fileType) {
            if (Objects.equals(type, "json")) {
                return jsonToMap(filetypeAndFile.get("json"));
            } else if (Objects.equals(type, "yml")) {
                return yamlToMap(filetypeAndFile.get("yml"));
            } else {
                throw new Exception("File type '" + type + "' not supported. " + "Please, select .json or .yml file");
            }
        }
        return null;
    }
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




}
