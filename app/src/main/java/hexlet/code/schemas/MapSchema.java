package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> initialRule = (object) -> object instanceof Map;
        addRule(initialRule);
    }

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> sizeof = (object) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<Object, Object> map = objectMapper.convertValue(object, Map.class);
            return map.size() == size;
        };
        addRule(sizeof);
        return this;
    }
}
