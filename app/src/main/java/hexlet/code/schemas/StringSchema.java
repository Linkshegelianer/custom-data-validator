package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<Object> initialRule = (object) -> object instanceof String;
        addRule(initialRule);
    }

    public StringSchema required() {
        setRequired();
        Predicate<Object> requiredString = (object) -> object != "";
        addRule(requiredString);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = (object) -> object.toString().length() >= length;
        addRule(minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<Object> contains = (object) -> object.toString().contains(substring);
        addRule(contains);
        return this;
    }
}
