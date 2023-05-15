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

//    @Test
//    void testRequired() {
//        assertTrue(schema.isValid(null));
//
//        schema.required();
//
//        assertFalse(schema.isValid(null));
//        assertTrue(schema.isValid(10));
//    }

    @Test
    void testPositive() {
        schema.positive();

        assertFalse(schema.isValid(0)); // pass
        assertFalse(schema.isValid(-10)); // pass
        assertTrue(schema.isValid(10));
    }

    @Test
    void range() {
        schema.range(5, 10);
        assertTrue(schema.isValid(5)); // pass
        assertTrue(schema.isValid(10)); // pass
        assertFalse(schema.isValid(4)); // pass
        assertFalse(schema.isValid(11)); // pass
    }
}
