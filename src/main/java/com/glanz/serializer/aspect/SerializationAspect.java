package com.glanz.serializer.aspect;

import com.glanz.serializer.util.CustomSerializer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Map;

@Aspect
@Component
public class SerializationAspect {

    @Around("execution(* com.glanz.serializer.controller..*(..))")
    public Object serializeReturnValue(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        if (result == null) {
            return null;
        }

        if (isPrimitiveOrWrapper(result.getClass())) {
            return result;
        }

        Map<String, Object> serialized = CustomSerializer.serialize(result);
        return serialized;
    }

    private boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz == String.class ||
                Number.class.isAssignableFrom(clazz) ||
                clazz == Boolean.class ||
                clazz == Character.class;
    }
}
