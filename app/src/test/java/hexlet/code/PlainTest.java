package hexlet.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class PlainTest {


    @Test
    void standartVariant() {
        Map<String, String> proceedMap = Map.of("int1", "unchanged", "String1", "changed",
                "array1", "deleted", "obj1", "added");


        Map<String, Object> map1 = Map.of("int1", 1, "String1", "value1",
                "array1", "[complex value]");
        Map<String, Object> map2 = Map.of("int1", 1, "String1", "value2",
                "obj1", "[complex value]");

        String expected = "Property 'String1' was updated. From 'value1' to 'value2'\n"
                + "Property 'array1' was removed\n"
                + "Property 'obj1' was added with value: [complex value]";

        String actual = Plain.format(proceedMap, map1, map2);

        assertThat(actual).isEqualTo(expected);
    }

}
