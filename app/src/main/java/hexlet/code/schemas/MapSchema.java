package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> initialRule = (object) -> object instanceof Map;
        addRule(initialRule);
    }

    public MapSchema required() {
        setRequired();
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> sizeof = (object) -> ((Map) object).size() == size;
        addRule(sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> input) {
        Predicate<Object> shape = (object) -> {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<Object, Object> map = objectMapper.convertValue(object, Map.class);

            for (Map.Entry<String, BaseSchema> schema : input.entrySet()) {
                String schemaKey = schema.getKey();
                Object value = map.get(schemaKey);

                if (!schema.getValue().isValid(value)) {
                    return false;
                }
            }
            return true;
        };
        addRule(shape);
        return this;
    }
}
