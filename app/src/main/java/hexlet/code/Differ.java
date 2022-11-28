package hexlet.code;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;


public class Differ {



    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
//        читаем входные файлы и расширение (json, yml)
//        на основе формата данных(получили из расширения фалйла) парсим данные в мапу, получается 2 мапы

        Map<String, Object> map1 = checkFileNull(Parser.parse(filePath1));
        Map<String, Object> map2 = checkFileNull(Parser.parse(filePath2));


        switch (formatName) {
            case "stylish":
                Map<String, String> proceedMap = differMap(checkFileArrayToString(map1), checkFileArrayToString(map2));
                return Stylish.format(proceedMap, map1, map2);
            case "plain":
                Map<String, String> proceedMapPlain = differMap(checkFileArrayToComplexValue(map1),
                        checkFileArrayToComplexValue(map2));
                return Plain.format(proceedMapPlain, map1, map2);
            case "json":
                Map<String, String> proceedMapJson = differMap(checkFileArrayToComplexValue(map1),
                        checkFileArrayToComplexValue(map2));
                return Json.format(proceedMapJson, map1, map2);

            default:
                throw new Exception("no format selected");
        }

    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }




    public static Map checkFileNull(Map<String, Object> file) {
        Map<String, Object> checkFile = file;
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            var value = checkFile.get(object.getKey());

            if (value == null) {
                checkFile.put(object.getKey(), "null");
            }
        }
        return file;
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

    public static Map checkFileArrayToComplexValue(Map<String, Object> file) {
        Map<String, Object> checkFile = file;
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            var value = file.get(object.getKey());
            if (value instanceof String
                    || value instanceof Character) {
                checkFile.put(object.getKey(), ("\'" + value + "\'"));
            }
            if (value instanceof LinkedHashMap
                    || value instanceof ArrayList) {
                checkFile.put(object.getKey(), "[complex value]");
            }
        }

        return checkFile;
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
            } else if (!file1.get(key).equals(file2.get(key))) {
                proceedMap.put(key, "changed");
            } else {
                proceedMap.put(key, "unchanged");
            }
        }

        return proceedMap;
    }
}
