package top.lytree.aop.framework;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.*;
import net.bytebuddy.matcher.ElementMatchers;

import top.lytree.aop.aspectJ.AdvisedSupport;
import top.lytree.aop.aspectJ.TargetSource;

import java.lang.reflect.Method;

public class BytebuddyAopProxy implements AopProxy {
    private final AdvisedSupport advised;

    public BytebuddyAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        try {
            return new ByteBuddy().subclass(advised.getTargetSource().getTarget().getClass())
                    .method(ElementMatchers.any())
                    .intercept(MethodDelegation.to(new AopInterceptor(advised))).make()
                    .load(this.getClass().getClassLoader())
                    .getLoaded()
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static class AopInterceptor {
        private final AdvisedSupport advised;

        public AopInterceptor(AdvisedSupport advised) {
            this.advised = advised;
        }

        /**
         * @param proxy       当前被拦截的、动态生成的那个对象
         * @param method      被拦截的源方法
         * @param superMethod 用于调用父类版本的方法
         * @param args        绑定所有参数的数组
         * @return
         * @throws Throwable
         */
//        @RuntimeType
        public Object interceptor(@This Object proxy, @Origin Method method,
                                  @SuperMethod Method superMethod,
                                  @AllArguments Object[] args) throws Throwable {
            BytebuddyMethodInvocation methodInvocation = new BytebuddyMethodInvocation(advised.getTargetSource().getTarget(), superMethod, args, method);
            if (advised.getMethodMatcher().matches(method, advised.getTargetSource().getTarget().getClass())) {
                //代理方法
                return advised.getMethodInterceptor().invoke(methodInvocation);
            }

            return methodInvocation.proceed();
        }
    }

    static class BytebuddyMethodInvocation extends ReflectiveMethodInvocation {

        private final Method methodProxy;

        public BytebuddyMethodInvocation(Object target, Method method, Object[] arguments, Method methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.arguments);
        }
    }
}
