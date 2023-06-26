package top.lytree.bean.factory.config;

import top.lytree.bean.factory.HierarchicalBeanFactory;
import top.lytree.core.convert.ConversionService;
import top.lytree.utils.StringValueResolver;

public  interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

//    /**
//     * 销毁单例bean
//     */
//    void destroySingletons();
//
//    void addEmbeddedValueResolver(StringValueResolver valueResolver);
//
//    String resolveEmbeddedValue(String value);
//
//    void setConversionService(ConversionService conversionService);
//
//    ConversionService getConversionService();

}