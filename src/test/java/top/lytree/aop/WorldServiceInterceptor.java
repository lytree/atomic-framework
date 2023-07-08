package top.lytree.aop;

import top.lytree.aop.aopalliance.intercept.MethodInterceptor;
import top.lytree.aop.aopalliance.intercept.MethodInvocation;

public class WorldServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Do something before the earth explodes");
        Object result = invocation.proceed();
        System.out.println("Do something after the earth explodes");
        return result;
    }
}
