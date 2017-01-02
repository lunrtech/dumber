package tech.lunr.dumber.pojo;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Rule {

    private Field field;
    private long    min          = 0;
    private long    max          = 0;
    private String  pattern      = null;
    private boolean isId         = false;
    private boolean isEnumerated = false;
    private boolean isSuperField = false;
    private Class   enumClazz    = null;
    private Type    genericType  = null;

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

    public boolean isEnumerated() {
        return isEnumerated;
    }

    public void setEnumerated(boolean enumerated) {
        isEnumerated = enumerated;
    }

    public Class getEnumClazz() {
        return enumClazz;
    }

    public void setEnumClazz(Class enumClazz) {
        this.enumClazz = enumClazz;
    }

    public boolean isSuperField() {
        return isSuperField;
    }

    public void setSuperField(boolean superField) {
        isSuperField = superField;
    }

    public Type getGenericType() {
        return genericType;
    }

    public void setGenericType(Type genericType) {
        this.genericType = genericType;
    }
}
