package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    private static NumberSchema schema;

    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.number();
    }

    @Test
    void testRequired() { // pass
        assertTrue(schema.isValid(null)); // pass
        assertTrue(schema.positive().isValid(null)); // pass

        schema.required();

        assertFalse(schema.isValid(null)); // pass
        assertTrue(schema.isValid(10)); // pass
    }

    @Test
    void testPositive() { // pass
        schema.positive();

        assertFalse(schema.isValid(0)); // pass
        assertFalse(schema.isValid(-10)); // pass
        assertTrue(schema.isValid(10)); // pass
    }

    @Test
    void range() { // pass
        schema.range(5, 10);
        assertTrue(schema.isValid(5)); // pass
        assertTrue(schema.isValid(10)); // pass
        assertFalse(schema.isValid(4)); // pass
        assertFalse(schema.isValid(11)); // pass
    }
}
