package top.lytree.bean.factory.support;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.DefaultMethodCall;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.HashCodeMethod;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import top.lytree.bean.BeansException;
import top.lytree.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * bytebuddy 实例化对象
 */
public class BytebuddySubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        ByteBuddy byteBuddy = new ByteBuddy();
        Class clazz = byteBuddy.subclass(beanDefinition.getBeanClass())
                .method(ElementMatchers.isHashCode()).intercept(SuperMethodCall.INSTANCE)
                .method(ElementMatchers.isToString()).intercept(SuperMethodCall.INSTANCE)
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();
        try {
            if (null == ctor) return clazz.getDeclaredConstructor().newInstance();
            return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
