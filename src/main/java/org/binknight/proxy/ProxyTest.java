package org.binknight.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Runnable thread = new Thread();
        Runnable o = (Runnable) Proxy.newProxyInstance(thread.getClass().getClassLoader(),
                thread.getClass().getInterfaces(),new UserInvocationHandler(thread) );
        o.run();
    }
}

class UserInvocationHandler implements InvocationHandler {
    Runnable user;

    public UserInvocationHandler(Runnable user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("功能增强了");
        Object invoke = method.invoke(user, args);
        return invoke;
    }
}


