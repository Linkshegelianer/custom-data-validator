package hexlet.code.schemas;

public class NumberSchema {

    private boolean isRequired = false;

    private boolean isPositive = false;

    private int lowerBound;
    private int upperBound;


    public NumberSchema required() {
        isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(int lower, int upper) {
        lowerBound = lower;
        upperBound = upper;
        return this;
    }


    public boolean isValid(Integer value) {

        if (isRequired && value == null) {
            return false;
        }
        if (isPositive && value <= 0)  {
            return false;
        }
        if (value != null && (value < lowerBound || value > upperBound)) {
            return false;
        }
        return true;
    }

}
