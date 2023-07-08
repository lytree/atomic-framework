package top.lytree.aop;

import org.junit.Before;
import org.junit.Test;
import top.lytree.aop.aspectJ.AdvisedSupport;
import top.lytree.aop.aspectJ.AspectJExpressionPointcut;
import top.lytree.aop.aspectJ.MethodMatcher;
import top.lytree.aop.aspectJ.TargetSource;
import top.lytree.aop.framework.BytebuddyAopProxy;
import top.lytree.aop.framework.JdkDynamicAopProxy;

public class DynamicProxyTest {
    private AdvisedSupport advisedSupport;

    @Before
    public void setup() throws Exception {
        WorldService worldService = new WorldServiceImpl();

         advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* top.lytree.aop.WorldService.explode1(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode1();
    }

    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new BytebuddyAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
