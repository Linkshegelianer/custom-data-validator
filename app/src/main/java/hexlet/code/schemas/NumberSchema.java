package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        Predicate<Object> initialRule = (object) -> object instanceof Integer;
        addRule(initialRule);
    }

    public NumberSchema required() {
        setRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positive = (object) -> (object == null || (Integer) object > 0);
        addRule(positive);
        return this;
    }

    public NumberSchema range(int lowerBound, int upperBound) {
        Predicate<Object> range = (object) -> ((Integer) object >= lowerBound && (Integer) object <= upperBound);
        addRule(range);
        return this;
    }
}
