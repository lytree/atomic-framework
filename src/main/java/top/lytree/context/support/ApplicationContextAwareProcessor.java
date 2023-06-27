package top.lytree.context.support;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.config.BeanPostProcessor;
import top.lytree.context.ApplicationContext;
import top.lytree.context.ApplicationContextAware;

public class ApplicationContextAwareProcessor  implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
