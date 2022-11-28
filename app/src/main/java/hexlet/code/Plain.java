package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Plain {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = new String();
        Set<String> keys = new TreeSet<>();


        keys.addAll(proceedMap.keySet());

        for (String key :keys) {

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
        return result;

    }
}
