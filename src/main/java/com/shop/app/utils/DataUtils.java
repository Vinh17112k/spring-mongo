package com.shop.app.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.util.HtmlUtils;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SuppressWarnings("all")
public class DataUtils {

    private DataUtils() {
    }
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean notNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean nullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean nullOrEmpty(Collection objects) {
        return objects == null || objects.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    public static boolean notNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    /**
     * @param id : update id of any enity
     * @return true  id != null and id> 0 => case update , false ==> case insert
     */
    public static boolean isUpdateId(Long id){
        if(DataUtils.notNull(id) && id > 0){
            return true;
        }
        return false;
    }


    public static boolean notNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static String parseToString(Object value, String defaultVal) {
        return value != null ? String.valueOf(value) : defaultVal;
    }

    public static boolean nullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }
    public static void trimValues(Object model) {
        List<Field> allField = Arrays.stream(model.getClass().getDeclaredFields()).collect(Collectors.toList());
        if (model.getClass().getSuperclass() != null) {
            List<Field> allFieldParent = Arrays.stream(model.getClass().getSuperclass().getDeclaredFields()).collect(Collectors.toList());
            allField.addAll(allFieldParent);
        }
        for (Field field : allField) {
            try {
                field.setAccessible(true);
                Object value = field.get(model);
                if (value != null) {
                    if (value instanceof String) {
                        String strValue = (String) value;
                        field.set(model, strValue.trim());
                    }
                }
            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    public static void trimNested(Object nestedObject) {
        if (nestedObject != null) {
            DataUtils.trimValues(nestedObject);
            Field[] fields = nestedObject.getClass().getDeclaredFields();
            for (Field field : fields) {
                java.lang.annotation.Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Nested) {
                        Nested nested = (Nested) annotation;
                        field.setAccessible(true);
                        if (nested.isCollection()) {
                            Collection<Object> collection = (Collection<Object>) ReflectionUtils.getField(field, nestedObject);
                            if (collection != null)
                                collection.forEach(DataUtils::trimNested);
                        } else {
                            Object value = ReflectionUtils.getField(field, nestedObject);
                            if (value != null) {
                                DataUtils.trimValues(value);
                                trimNested(value);
                            }
                        }
                    }
                }
            }
        }
    }
    public static <T> List<String> validate(T obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        if (!CollectionUtils.isEmpty(violations)) {
            return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    public static boolean safeEqual(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equals(obj1.toString()));
    }

    public static boolean safeEqualIgnoreCase(Object obj1, Object obj2) {
        return ((obj1 != null) && (obj2 != null) && obj2.toString().equalsIgnoreCase(obj1.toString()));
    }
}

