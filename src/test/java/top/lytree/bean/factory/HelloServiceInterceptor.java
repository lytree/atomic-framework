package top.lytree.bean.factory;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;

public class HelloServiceInterceptor {


    @RuntimeType
    public Object interceptor(@This Object proxy, @Origin Method method,
                              @SuperMethod Method superMethod,
                              @AllArguments Object[] args) throws Exception {
        System.out.println("bytebuddy delegate proxy2 before sing ");
        Object ret = superMethod.invoke(proxy, args);
        System.out.println("bytebuddy delegate proxy2 after sing ");
        return ret;
    }
}
