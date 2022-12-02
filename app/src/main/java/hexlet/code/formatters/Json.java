package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.JsonSerialize;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;


public class Json {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2)
            throws JsonProcessingException {

        map1 = checkNull(map1);
        map2 = checkNull(map2);

        Set<String> keys = new TreeSet<>();

        JsonSerialize result = new JsonSerialize();

        keys.addAll(proceedMap.keySet());
        List<Map<String, Object>> added = new ArrayList<>();
        List<Map<String, Object>> deleted = new ArrayList<>();
        List<List<Map<String, Object>>> changed = new ArrayList<>();
        List<Map<String, Object>> changedFrom = new ArrayList<>();
        List<Map<String, Object>> changedTo = new ArrayList<>();
        List<Map<String, Object>> unchanged = new ArrayList<>();

        for (String key : keys) {

            switch (proceedMap.get(key)) {
                case "added":
                    added.add(Map.of(key, map2.get(key)));
                    break;
                case "deleted":
                    deleted.add(Map.of(key, map1.get(key)));
                    break;
                case "changed":
                    changedFrom.add(Map.of(key, map1.get(key)));
                    changedTo.add(Map.of(key, map2.get(key)));
                    break;
                case "unchanged":
                    unchanged.add(Map.of(key, map1.get(key)));
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }
        }
        result.setAdded(added);
        result.setDeleted(deleted);
        result.setUnchanged(unchanged);


        changed.add(changedFrom);
        changed.add(changedTo);
        result.setChanged(changed);

        String serialized = new ObjectMapper().writeValueAsString(result);

        return serialized;

    }

    public static Map checkNull(Map<String, Object> file) {
        Map<String, Object> checkFile = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        checkFile.putAll(file);
        for (Map.Entry<String, Object> object : checkFile.entrySet()) {
            String key = object.getKey();
            var value = checkFile.get(key);
            if (value == null) {
                resultMap.put(key, "null");
            } else {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}
