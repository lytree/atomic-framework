package top.lytree.aop.aspectJ;

import java.lang.reflect.Method;

public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
