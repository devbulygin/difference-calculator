package hexlet.code;


import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Label {
    public static Map differTwoMap(Map file1, Map file2) {
        Set<String> keys = new TreeSet<>();

        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        Map<String, Status> diff = new TreeMap<>();

        for (String key : keys) {
            if (!file1.containsKey(key)) {
                diff.put(key, new Status("added", file1.get(key), file2.get(key)));
            } else if (!file2.containsKey(key)) {
                diff.put(key, new Status("deleted", file1.get(key), file2.get(key)));
            } else if (!(Objects.equals(file1.get(key), file2.get(key)))) {
                diff.put(key, new Status("changed", file1.get(key), file2.get(key)));
            } else {
                diff.put(key, new Status("unchanged", file1.get(key), file2.get(key)));
            }

        }
        return diff;
    }

}
