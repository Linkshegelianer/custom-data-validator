package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    private boolean isRequired = false;

    private int maxSize = 0;

    public MapSchema required() {
        isRequired = true;
        return this;
    }

    public MapSchema sizeof(int number) {
        maxSize = number;
        return this;
    }
}
