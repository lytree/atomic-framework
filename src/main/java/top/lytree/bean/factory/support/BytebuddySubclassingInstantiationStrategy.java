package top.lytree.bean.factory.support;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.*;
import net.bytebuddy.matcher.ElementMatchers;
import top.lytree.bean.BeansException;
import top.lytree.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * bytebuddy 实例化对象
 */
public class BytebuddySubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        ArrayList<TypeDescription.Generic> list = getGenerics(beanClass);
        Class clazz = new ByteBuddy().subclass(beanClass).implement(list)
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

    private static ArrayList<TypeDescription.Generic> getGenerics(Class<?> beanClass) {
        ArrayList<TypeDescription.Generic> list = new ArrayList<>();
        try {
            Type[] genericInterfaces = beanClass.getGenericInterfaces();
            for (Type type : genericInterfaces) {
                Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
                Class<?>[] classes = new Class[typeArguments.length];
                for (int i = 0; i < typeArguments.length; i++) {
                    classes[i] = Class.forName(typeArguments[i].getTypeName());
                }
                Class<?> aClass = Class.forName(((ParameterizedType) type).getRawType().getTypeName());
                TypeDescription.Generic listType = TypeDescription.Generic.Builder.parameterizedType(aClass, classes).build();
                list.add(listType);
            }
        } catch (ClassNotFoundException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
        return list;
    }
}
