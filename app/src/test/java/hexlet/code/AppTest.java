package hexlet.code;

import hexlet.code.schemas.Schema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private static StringSchema schema;

    @BeforeAll
    static void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    void testRequired() { // passes
        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("1234567")); // assert that no other condition is set
    }

    @Test
    void testMinLength() {
        schema.minLength(5);

//        assertTrue(schema.isValid("")); // assert that no other condition is set
        assertFalse(schema.isValid("12345")); // test minLength(), passes
    }
//
//    @Test
//    void testValidatorString() {
//
//
//
//
//        assertFalse(schema.isValid("12345")); // test minLength(), passes
//        assertTrue(schema.isValid("1234567"));
//
//        schema = v.string().minLength(5);
////
////        assertFalse(schema.isValid("123456")); // test contains()
////        assertTrue(schema.isValid("test1"));
//
//    }
}