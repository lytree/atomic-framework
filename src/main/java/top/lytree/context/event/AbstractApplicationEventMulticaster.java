package top.lytree.context.event;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.BeanFactory;
import top.lytree.bean.factory.BeanFactoryAware;
import top.lytree.context.ApplicationEvent;
import top.lytree.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractApplicationEventMulticaster  implements ApplicationEventMulticaster, BeanFactoryAware {
    protected final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
