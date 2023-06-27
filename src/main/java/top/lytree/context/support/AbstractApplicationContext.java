package top.lytree.context.support;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.ConfigurableListableBeanFactory;
import top.lytree.bean.factory.config.BeanFactoryPostProcessor;
import top.lytree.bean.factory.config.BeanPostProcessor;
import top.lytree.context.ConfigurableApplicationContext;
import top.lytree.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用上下文
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() throws BeansException {
        //创建beanFactory 并加载BeanDefinition
        refreshBeanFactory();
        //实例化beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //执行beanFactoryPostProcessors
        invokeBeanFactoryPostProcessors(beanFactory);

        //BeanPostProcessor需要提前与其他bean实例化之前注册
        registerBeanPostProcessors(beanFactory);
        //提前实例化单例bean
        beanFactory.preInstantiateSingletons();
    }

    /**
     * @param beanFactory
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册BeanPostProcessor
     *
     * @param beanFactory
     */
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    protected abstract void refreshBeanFactory() throws BeansException;


    public abstract ConfigurableListableBeanFactory getBeanFactory();
}
