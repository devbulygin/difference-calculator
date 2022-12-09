//package hexlet.code.formatters;
//
//
//import hexlet.code.formatters.Plain;
//import org.junit.jupiter.api.Test;
//import java.util.Map;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class PlainTest {
//
//
//    @Test
//    void standartVariant() {
//        Map<String, String> proceedMap = Map.of("int1", "unchanged", "String1", "changed",
//                "String3", "deleted", "String4", "added");
//
//
//        Map<String, Object> map1 = Map.of("int1", 1, "String1", "value1",
//                "String3", "value3");
//        Map<String, Object> map2 = Map.of("int1", 1, "String1", "value2",
//                "String4", "value4");
//
//        String expected = "Property 'String1' was updated. From 'value1' to 'value2'\n"
//                + "Property 'String3' was removed\n"
//                + "Property 'String4' was added with value: 'value4'";
//
//        String actual = Plain.format(proceedMap, map1, map2);
//
//        assertThat(actual).isEqualTo(expected);
//    }
//
//}
