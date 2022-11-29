package hexlet.code;

import org.apache.commons.lang3.StringUtils;

import java.util.*;


public class Plain {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = new String();
        Set<String> keys = new TreeSet<>(proceedMap.keySet());
        map1 = checkFileArrayToComplexValue(map1);
        map2 = checkFileArrayToComplexValue(map2);

        for (String key : keys) {

            switch (proceedMap.get(key)) {
                case "added":
                    result += "Property " + "\'" + key + "\'" + " was added with value: "
                            + map2.get(key) + "\n";
                    break;
                case "deleted":
                    result += "Property " + "\'" + key + "\'" + " was removed" + "\n";
                    break;
                case "changed":
                    result += "Property " + "\'" + key + "\'" + " was updated. From "
                            + map1.get(key) + " to " + map2.get(key) + "\n";
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }

        }

        return StringUtils.chop(result);

    }

    public static Map checkFileArrayToComplexValue(Map<String, Object> file) {
        Map<String, Object> checkFile = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        checkFile.putAll(file);
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            String key = object.getKey();
            var value = checkFile.get(object.getKey());
            if (value instanceof String
                    || value instanceof Character) {
                resultMap.put(key, "\'" + value + "\'");
            } else if (value instanceof LinkedHashMap ||
                    value instanceof Arrays) {
                resultMap.put(key, "[complex value]");
            } else {
                resultMap.put(key, value);
            }


            }
            return resultMap;
        }
    }



//    public static Map quoteString(Map<String, Object> file) {
//        Map<String, Object> checkFile = new HashMap<>();
//        checkFile.putAll(file);
//        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
//            var value = checkFile.get(object.getKey());
//            if (value == null) {
//                checkFile.put(object.getKey(), null);
//            } else {
//
//                }
//            }
//
//        }
//        return checkFile;

//    }

