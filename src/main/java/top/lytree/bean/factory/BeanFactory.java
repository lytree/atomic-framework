package top.lytree.bean.factory;

import java.util.HashMap;
import java.util.Map;

public interface BeanFactory {

    public Object getBean(String name, Object... args);
}
