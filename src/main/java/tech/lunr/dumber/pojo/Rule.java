package tech.lunr.dumber.pojo;

import java.lang.reflect.Field;

/**
 * Created by IB on 2016. 12. 31..
 */
public class Rule {

    private Field field;
    private long min = 0;
    private long max = Long.MAX_VALUE;
    private String pattern = null;
    private boolean isId = false;

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }
}
