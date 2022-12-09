//package hexlet.code.formatters;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import hexlet.code.formatters.Json;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Map;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//class JsonTest {
//    @BeforeEach
//    public void beforeEach() {
//
//
//    }
//
//    @Test
//    void format() throws JsonProcessingException {
//        Map<String, String> proceedMap = Map.of("int1", "unchanged", "String1", "changed",
//                "array1", "deleted", "obj1", "added");
//
//        Map<String, Object> map1 = Map.of("int1", 1, "String1", "value1",
//                "array1", "[complex value]");
//        Map<String, Object> map2 = Map.of("int1", 1, "String1", "value2",
//                "obj1", "[complex value]");
//
//        String expected = "{\"added\":[{\"obj1\":\"[complex value]\"}],"
//                + "\"deleted\":[{\"array1\":\"[complex value]\"}],"
//                + "\"changed\":[[{\"String1\":\"value1\"}],[{\"String1\":\"value2\"}]],"
//                + "\"unchanged\":[{\"int1\":1}]}";
//
//        String actual = Json.format(proceedMap, map1, map2);
//
//        assertThat(actual).isEqualTo(expected);
//    }
//}
