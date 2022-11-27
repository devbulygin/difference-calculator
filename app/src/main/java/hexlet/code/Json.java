package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;



public class Json {
    public static String format(Map<String, String> proceedMap, Map<String, Object> map1, Map<String, Object> map2)
            throws JsonProcessingException {

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
        changed.add(changedFrom);
        changed.add(changedTo);


        result.setAdded(added);
        result.setDeleted(deleted);
        result.setUnchanged(unchanged);
        result.setChanged(changed);

        String serialized = new ObjectMapper().writeValueAsString(result);

        return serialized;

    }
}
