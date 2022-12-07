package hexlet.code;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        String content1 = readContent(filePath1);
        String content2 = readContent(filePath2);
        String dataFormat1 = FilenameUtils.getExtension(filePath1);
        String dataFormat2 = FilenameUtils.getExtension(filePath2);

        Map<String, Object> map1 = Parser.parse(content1, dataFormat1);
        Map<String, Object> map2 = Parser.parse(content2, dataFormat2);


        Map<String, Status> diff = Label.differTwoMap(map1, map2);


        return Formatter.format(diff, formatName);
    }

    public static String readContent(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + pathToFile + "' does not exist");
        }
        String content = Files.readString(path);
        if (content.isEmpty()) {
            content = "{}";
        }

        return content;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }


}
