package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {


    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;
    private static MapSchema mapSchema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        stringSchema = v.string();
        numberSchema = v.number();
        mapSchema = v.map();
    }

    @Test
    void testStringSchema() {
        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));

        stringSchema.required();

        assertFalse(stringSchema.isValid(null));
        assertFalse(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid("1234567"));

        stringSchema.minLength(5);

        assertTrue(stringSchema.isValid("12345"));
        assertFalse(stringSchema.isValid("1234"));

        stringSchema.contains("wh");

        assertTrue(stringSchema.isValid("what does the fox say"));
        assertFalse(stringSchema.isValid("this song is no longer popular"));
    }

    @Test
    void testNumberSchema() {
        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.positive().isValid(null));

        numberSchema.required();

        assertFalse(numberSchema.isValid(null));
        assertTrue(numberSchema.isValid(10));

        numberSchema.positive();

        assertFalse(numberSchema.isValid(0));
        assertFalse(numberSchema.isValid(-10));
        assertTrue(numberSchema.isValid(10));

        numberSchema.range(5, 10);

        assertTrue(numberSchema.isValid(5));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(4));
        assertFalse(numberSchema.isValid(11));
    }

    @Test
    void testMapSchema() {
        assertTrue(mapSchema.isValid(null));

        mapSchema.required();

        assertFalse(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid(new HashMap()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));

        mapSchema.sizeof(2);
        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));
    }
}
