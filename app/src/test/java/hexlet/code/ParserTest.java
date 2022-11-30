package hexlet.code;


import org.junit.jupiter.api.Test;



import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {
    public static final int FIFTY = 50;

    @Test
    void readJson() throws Exception {
        String relativeJsonPath = "./src/test/resources/fixtures/file1.json";
        String relativeYamlPath = "./src/test/resources/fixtures/filepath1.yml";
        String relativeXmlPath = "./src/test/resources/fixtures/file1.xml";

        Map expected2 = Map.of("follow", false, "host", "hexlet.io", "proxy", "123.234.53.22",
                "timeout", FIFTY);

        assertThat(Parser.parse(relativeJsonPath)).isEqualTo(expected2);
        assertThat(Parser.parse(relativeYamlPath)).isEqualTo(expected2);

        Exception exception = assertThrows(Exception.class, () -> {
            Parser.parse(relativeXmlPath);
        });

        String expectedMessage = "File type 'xml' not supported. Please, select .json or .yml file";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
