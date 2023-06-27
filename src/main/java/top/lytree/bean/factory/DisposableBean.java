package top.lytree.bean.factory;

/**
 * Bean 销毁
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
