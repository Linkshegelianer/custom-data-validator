package project.code;

import project.code.schemas.MapSchema;
import project.code.schemas.NumberSchema;
import project.code.schemas.StringSchema;

public final class Validator {
    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public MapSchema map() {
        return new MapSchema();
    }
}
