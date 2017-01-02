package tech.lunr.dumber.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.Entity;

import tech.lunr.dumber.field.Util;
import tech.lunr.dumber.pojo.Rule;
import tech.lunr.dumber.value.ValueGenerator;

@Singleton
public class DumberBuilder {

    private static Logger log = LoggerFactory.getLogger(DumberBuilder.class);

    public List mock(Class clazz, int amount) {
        List result = new ArrayList();
        try {
            Util util = new Util();
            int idx = 0;
            for (int i = 0; i < amount; i++) {
                List<Rule> rules = util.scanFields(clazz);
                Class<?> instance = Class.forName(clazz.getName());
                Constructor<?> ctr = clazz.getConstructor();
                Object obj = ctr.newInstance();
                log.info("{} object created", obj.getClass().getName());
                idx++;
                buildObject(idx, rules, obj);
                log.info("{} written instance: {}", obj.getClass().getSimpleName(), obj.toString());
                result.add(obj);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            log.error("Can't mock object", e);
        }
        return result;
    }

    public Object mock(Class clazz) {
        try {
            Util util = new Util();
            int idx = 0;
            List<Rule> rules = util.scanFields(clazz);
            Class<?> instance = Class.forName(clazz.getName());
            Constructor<?> ctr = clazz.getConstructor();
            Object obj = ctr.newInstance();
            log.info("{} object created", obj.getClass().getName());
            idx++;
            buildObject(idx, rules, obj);
            log.info("{} written instance: {}", obj.getClass().getSimpleName(), obj.toString());
            return obj;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            log.error("Can't mock object", e);
        }
        return null;
    }

    private void buildObject(long idx, List<Rule> rules, Object obj) throws NoSuchFieldException, IllegalAccessException {
        for (Rule rule : rules) {
            Field f = obj.getClass().getDeclaredField(rule.getField().getName());
            f.setAccessible(true);
            if (f.getType() == Long.class && rule.isId()) {
                f.set(obj, idx);
            } else if (f.getType() == Long.class) {
                f.set(obj, (long) ValueGenerator.generateInt());
            } else if (f.getType() == String.class) {
                f.set(obj, ValueGenerator.generateString(rule.getMin(), rule.getMax(), rule.getPattern()));
            } else if (f.getType() == int.class || f.getType() == Integer.class) {
                f.set(obj, ValueGenerator.generateInt());
            } else if (f.getType() == boolean.class || f.getType() == Boolean.class) {
                f.set(obj, ValueGenerator.generateBool());
            } else if (f.getType() == ZonedDateTime.class) {
                f.set(obj, ZonedDateTime.now());
            } else if (f.getType() == LocalDate.class) {
                f.set(obj, LocalDate.now());
            } else if (rule.isEnumerated()) {
                Field[] eFields = rule.getEnumClazz().getDeclaredFields();
                Field eField = eFields[ValueGenerator.generateInt(0, eFields.length - 2)];
                f.set(obj, Enum.valueOf((Class<Enum>) eField.getType(), eField.getName()));
            } else if (f.getType().isAnnotationPresent(Entity.class)) {
                Object child = mock(f.getType());
                f.set(obj, child);
            } else if (Collection.class.isAssignableFrom(f.getType())) {
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                Class<?> listClass = (Class<?>) pType.getActualTypeArguments()[0];
                List childs = mock(listClass, 3);
                f.set(obj, childs);
            }
        }
    }


}
