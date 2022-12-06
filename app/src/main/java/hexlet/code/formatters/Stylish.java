package hexlet.code.formatters;

import hexlet.code.Status;
import java.util.Map;


public class Stylish {
    public static String render(Map<String, Status> diff) {
        String result = "{\n";

        for (Map.Entry<String, Status> element : diff.entrySet()) {
            String key = element.getKey();
            Status value = element.getValue();
            String type = value.getStatusName();
            switch (type) {
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
                    throw new RuntimeException("Unknown node type: '" + type + "'");
            }
        }
        result += "}";
        return result;

    }

}
