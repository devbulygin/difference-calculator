package hexlet.code;


import org.junit.jupiter.api.Test;



import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    void readJson() throws Exception {
        String relativeJsonPath = "./src/test/resources/fixtures/file1.json";
        String relativeYamlPath = "./src/test/resources/fixtures/filepath1.yml";
        String relativeXmlPath = "./src/test/resources/fixtures/file1.xml";

        Map expected2 = Map.of("follow", false, "host", "hexlet.io", "proxy", "123.234.53.22",
                "timeout", 50);

        assertThat(Parser.parse(relativeJsonPath)).isEqualTo(expected2);
        assertThat(Parser.parse(relativeYamlPath)).isEqualTo(expected2);

        Exception exception = assertThrows(Exception.class, () -> {
            Parser.parse(relativeXmlPath);
        });

        String expectedMessage = "File type'application/xml' not supportedPlease, select .json or .yml file";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

//    @Test
//    void yamlToMap() throws Exception {
//        String yaml = "host: hexlet.io\n" +
//                "timeout: 50\n" +
//                "proxy: 123.234.53.22";
//
//        Map expected1 = Map.of("host", "hexlet.io", "timeout", 50, "proxy", "123.234.53.22");
//
//
//
//        var actual1 = Parser.jsonToMap(yaml);
//
//
//        assertThat(actual1).isEqualTo(expected1);
//
//
//
//
//
//    }
}
