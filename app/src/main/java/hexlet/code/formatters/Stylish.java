package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.HashMap;
import java.util.Map;


public class Stylish {
    public static String render(Map<String, Status> diff) {


        String result = "{\n";

        for (Map.Entry<String, Status> element : diff.entrySet()) {
            String key = element.getKey();
            Status value = element.getValue();
            switch (value.getStatusName()) {
                case "added":
                    result += "  " + "+ " + key + ": " + value.getNewValue() + "\n";
                    break;
                case "deleted":
                    result += "  " + "- " + key + ": " + value.getOldValue() + "\n";
                    break;
                case "changed":
                    result += "  " + "- " + key + ": " + value.getOldValue() + "\n";
                    result += "  " + "+ " + key + ": " + value.getNewValue() + "\n";
                    break;
                case "unchanged":
                    result += "  " + "  " + key + ": " + value.getNewValue() + "\n";
                    break;
                default:
                    throw new RuntimeException("operation not found");
            }
        }
        result += "}";
        return result;

    }

    public static Map checkNull(Map<String, Object> file) {

        Map<String, Object> resultMap = new HashMap<>();

        for (Map.Entry<String, Object> object : file.entrySet()) {
            String key = object.getKey();
            if (object.getValue() == null) {
                resultMap.put(key, "null");
            } else {
                resultMap.put(key, file.get(key));
            }
        }
        return resultMap;
    }
}
