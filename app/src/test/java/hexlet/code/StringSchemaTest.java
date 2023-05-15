package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    private static StringSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    void testRequired() {
        assertTrue(schema.isValid("")); // pass
        assertTrue(schema.isValid(null)); // pass

        schema.required();

        assertFalse(schema.isValid(null)); // pass
        assertFalse(schema.isValid("")); // pass
        assertTrue(schema.isValid("1234567")); // pass
    }

    @Test
    void testMinLength() {
        schema.minLength(5);

        assertTrue(schema.isValid("12345")); // pass
        assertFalse(schema.isValid("1234")); // pass
    }

    @Test
    void testContains() {
        schema.contains("wh");

        assertTrue(schema.isValid("what does the fox say")); // pass
        assertFalse(schema.isValid("this song is no longer popular")); // pass
    }
}