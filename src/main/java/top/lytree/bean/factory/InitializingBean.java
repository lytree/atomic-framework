package top.lytree.bean.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
