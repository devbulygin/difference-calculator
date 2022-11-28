package hexlet.code;

import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;




public class Plain {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = new String();
        Set<String> keys = new TreeSet<>();
        keys.addAll(proceedMap.keySet());

        map1 = checkFileArrayToComplexValue(map1);
        map2 = checkFileArrayToComplexValue(map2);

        for (String key: keys) {

            switch (proceedMap.get(key)) {
                case "added":
                    result += "Property " + "\'" +  key + "\'" + " was added with value: "
                            + map2.get(key) + "\n";
                    break;
                case "deleted":
                    result += "Property " + "\'" +  key + "\'" +  " was removed" + "\n";
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
        Map<String, Object> checkFile = file;
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            var value = checkFile.get(object.getKey());
            if (value != null) {
                if (value instanceof String
                        || value instanceof Character) {
                    String quoteValue = "\'" + value + "\'";
                    checkFile.put(object.getKey(), quoteValue);
                }

                if (value instanceof LinkedHashMap
                        || value instanceof LinkedHashMap) {
                    checkFile.put(object.getKey(), "[complex value]");
                }
            } else {
                checkFile.put(object.getKey(), null);
            }
        }

        return checkFile;
    }
}
