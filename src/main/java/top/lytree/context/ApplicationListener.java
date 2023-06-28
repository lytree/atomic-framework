package top.lytree.context;

import java.util.EventListener;

/**
 * 事件监听
 * @param <E>
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    void onApplicationEvent(E event);
}
