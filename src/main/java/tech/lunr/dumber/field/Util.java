package tech.lunr.dumber.field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import tech.lunr.dumber.pojo.Rule;

/**
 * Field util
 *
 * @author IB
 */
@Singleton
public class Util<T> {


    private static Logger log = LoggerFactory.getLogger(Util.class);

    public Util() {}

    public List<Rule> scanFields(Class<T> clazz) {
        List<Rule> rules = new ArrayList<Rule>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Rule rule = new Rule();
                rule.setField(field);
                field.getType();
                log.debug("Found field {}.{}:{}", clazz.getSimpleName(), field.getName(), field.getType().getName());
                scanAnnotations(field, rule);
                rules.add(rule);
            }
        } catch (IllegalAccessException e) {
            log.error("Can't access field", e);
        } catch (NoSuchFieldException e) {
            log.error("Can't find field", e);
        }
        return rules;
    }

    public void scanAnnotations(Field field, Rule rule) throws IllegalAccessException, NoSuchFieldException {
        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            log.debug("Found annotation for field {} {}={}", field.getName(), annotation.annotationType());
            extractAnnotationValue(annotation, rule);
        }
    }

    public void extractAnnotationValue(Annotation annotation, Rule rule) throws NoSuchFieldException, IllegalAccessException {
        if (annotation.annotationType() == Min.class) {
            log.debug("Annotation value {}={}", annotation.annotationType(), ((Min)annotation).value());
            rule.setMin(((Min)annotation).value());
        } else if (annotation.annotationType() == Max.class) {
            log.debug("Annotation value {}={}", annotation.annotationType(), ((Max)annotation).value());
            rule.setMax(((Max)annotation).value());
        } else if (annotation.annotationType() == Pattern.class) {
            log.debug("Annotation patten {}={}", annotation.annotationType(), ((Pattern)annotation).regexp());
            rule.setPattern(((Pattern)annotation).regexp());
        } else if (annotation.annotationType() == Id.class) {
            log.debug("Annotation id found");
            rule.setId(true);
        }
    }


}
