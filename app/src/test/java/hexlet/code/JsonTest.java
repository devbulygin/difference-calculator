package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;


class JsonTest {
    static Map<String, String> proceedMap = new TreeMap<>();
    static Map<String, Object> map1 = new TreeMap<>();
    static Map<String, Object> map2 = new TreeMap<>();



    @BeforeEach
    public void beforeEach() {
        proceedMap = Map.of("int1", "unchanged", "String1", "changed",
                "array1", "deleted", "obj1", "added");

        map1 = Map.of("int1", 1, "String1", "value1",
                "array1", "[complex value]");
        map2 = Map.of("int1", 1, "String1", "value2",
                "obj1", "[complex value]");

    }

    @Test
    void format() throws JsonProcessingException {
        String expected = "{\"added\":[{\"obj1\":\"[complex value]\"}],\"deleted\":[{\"array1\":\"[complex value]\"}],"
                + "\"changed\":[[{\"String1\":\"value1\"}],[{\"String1\":\"value2\"}]],\"unchanged\":[{\"int1\":1}]}";

        String actual = Json.format(proceedMap, map1, map2);

        assertThat(actual).isEqualTo(expected);
    }
}
