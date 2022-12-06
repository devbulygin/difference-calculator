package hexlet.code.formatters;


import hexlet.code.Status;

import java.util.List;
import java.util.Map;


public class Plain {
    public static String render(Map<String, Status> diff) {
        String result = new String();


        for (Map.Entry<String, Status> element : diff.entrySet()) {
            String key = element.getKey();
            Status value = element.getValue();
            String type = value.getStatusName();
            switch (type) {
                case "added":
                    result += "Property " + "\'" + key + "\'" + " was added with value: "
                            + stringify(value.getNewValue()) + "\n";
                    break;
                case "deleted":
                    result += "Property " + "\'" + key + "\'" + " was removed" + "\n";
                    break;
                case "changed":
                    result += "Property " + "\'" + key + "\'" + " was updated. From "
                            + stringify(value.getOldValue()) + " to " + stringify(value.getNewValue()) + "\n";
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("Unknown node type: '" + type + "'");
            }

        }

        return (result == null || result.length() == 0) ? null : (result.substring(0, result.length() - 1));

    }

    public static String stringify(Object value) {

        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }

        return value.toString();
    }


}




