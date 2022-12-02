package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Comparing {
    public static Map differTwoMap(Map file1, Map file2) {
        Set<String> keys = new TreeSet<>();

        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        Map<String, String> proceedMap = new TreeMap<>();

        for (String key : keys) {

            if (!file1.containsKey(key)) {
                proceedMap.put(key, "added");
            } else if (!file2.containsKey(key)) {
                proceedMap.put(key, "deleted");
            } else if (!(Objects.equals(file1.get(key), file2.get(key)))) {
                proceedMap.put(key, "changed");
            } else {
                proceedMap.put(key, "unchanged");
            }

        }
        return proceedMap;
    }
}
