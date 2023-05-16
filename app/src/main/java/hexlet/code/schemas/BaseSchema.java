package hexlet.code.schemas;

import java.util.*;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> rules = new ArrayList<>();

    private boolean isRequired = false;

    public final boolean isValid(Object value) {
        if (!isRequired && value == null) {
            return true;
        }

        for (Predicate<Object> rule : rules) {
            if (!rule.test(value)) {
                return false;
            }
        }
        return true;
    }

    protected final void addRule(Predicate<Object> rule) {
        rules.add(rule);
    }

    protected final void setRequired() {
        this.isRequired = true;
    }
}
