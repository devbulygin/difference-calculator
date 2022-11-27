package hexlet.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class PlainTest {
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
    void standartVariant() {

        String expected = "Property 'String1' was updated. From 'value1' to 'value2'\n"
                + "Property 'array1' was removed\n"
                + "Property 'obj1' was added with value: '[complex value]'\n";

        String actual = Plain.format(proceedMap, map1, map2);

        assertThat(expected).containsAnyOf(actual);


    }

}
