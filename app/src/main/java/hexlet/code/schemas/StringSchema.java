package hexlet.code.schemas;

public class StringSchema implements Schema {

    private boolean isRequired = false;
    private int minLength = 0;
    private String containsSubstring = null;

    public StringSchema required() {
        isRequired = true;
        return this; // method chaining/fluent interface, return reference to the current object
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        containsSubstring = substring;
        return this;
    }

    @Override
    public boolean isValid(String value) {
        if (isRequired && (value == null || value.isEmpty())) {
            return false;
        }
        if (value.length() < minLength) {
            return false;
        }
        if (containsSubstring != null && !value.contains(containsSubstring)) {
            return false;
        }
        return true;
    }

}