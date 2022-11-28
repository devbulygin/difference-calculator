package hexlet.code;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Objects;

public class Differ {



    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
//        читаем входные файлы и расширение (json, yml)
//        на основе формата данных(получили из расширения фалйла) парсим данные в мапу, получается 2 мапы

        Map<String, Object> map1 = (Parser.parse(filePath1));
        Map<String, Object> map2 = (Parser.parse(filePath2));


        switch (formatName) {
            case "stylish":
                Map<String, String> proceedMap = differMap(checkFileArrayToString(map1), checkFileArrayToString(map2));
                return Stylish.format(proceedMap, map1, map2);
            case "plain":
                Map<String, String> proceedMapPlain = differMap(map1, map2);
                return Plain.format(proceedMapPlain, map1, map2);
            case "json":
                Map<String, String> proceedMapJson = differMap(map1, map2);
                return Json.format(proceedMapJson, map1, map2);

            default:
                throw new Exception("no format selected");
        }

    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }


    public static Map checkFileArrayToString(Map<String, Object> file) {
        Map<String, Object> checkFile = file;
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            var value = checkFile.get(object.getKey());
            if (value instanceof LinkedHashMap
                    || value instanceof ArrayList) {
                checkFile.put(object.getKey(), value.toString());
            }
        }
        return file;
    }




    public static Map differMap(Map file1, Map file2) {
        Set<String> keys = new TreeSet<>();

        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        Map<String, String> proceedMap = new TreeMap<>();



        for (String key : keys) {
            if (!file1.containsKey(key)) {
                proceedMap.put(key, "added");
            } else if (!file2.containsKey(key)) {
                proceedMap.put(key, "deleted");
            } else if (!Objects.equals(file1.get(key), file2.get(key))) {
                proceedMap.put(key, "changed");
            } else {
                proceedMap.put(key, "unchanged");
            }
        }

        return proceedMap;
    }
}
