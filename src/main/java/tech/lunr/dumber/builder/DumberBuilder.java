package tech.lunr.dumber.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.inject.Singleton;

import tech.lunr.dumber.field.Util;
import tech.lunr.dumber.pojo.Rule;
import tech.lunr.dumber.value.StringGenerator;


@Singleton
public class DumberBuilder {

    private static Logger log = LoggerFactory.getLogger(DumberBuilder.class);

    public void mock(Class clazz) {
        try {
            Util util = new Util();
            List<Rule> rules = util.scanFields(clazz);
            Class<?> instance = Class.forName(clazz.getName());
            Constructor<?> ctr = clazz.getConstructor();
            Object obj = ctr.newInstance();
            log.info("{} object created", obj.getClass().getName());
            int idx = 0;
            for (Rule rule : rules) {
                idx++;
                Field f = obj.getClass().getDeclaredField(rule.getField().getName());
                f.setAccessible(true);
                if (f.getType() == Long.class && rule.isId()) {
                    f.set(obj, (long)idx);
                } else if (f.getType() == String.class) {
                    f.set(obj, StringGenerator.generate(rule.getMin(), rule.getMax(), rule.getPattern()));
                } else if (f.getType() == int.class) {
                    f.set(obj, 10);
                }
            }
            log.info("{} written instance: {}", obj.getClass().getName(), obj.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            log.error("Can't mock object", e);
        }
    }


}
