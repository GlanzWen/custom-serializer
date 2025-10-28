package com.glanz.serializer.util;

import com.glanz.serializer.annotation.SerializableField;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomSerializer {

    public static Map<String, Object> serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> result = new LinkedHashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(SerializableField.class)) {
                field.setAccessible(true);
                SerializableField anno = field.getAnnotation(SerializableField.class);
                String key = anno.value().isEmpty() ? field.getName() : anno.value();
                try {
                    Object value = field.get(obj);
                    result.put(key, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("序列化字段失败：" + field.getName(), e);
                }
            }
        }
        return result;
    }
}
