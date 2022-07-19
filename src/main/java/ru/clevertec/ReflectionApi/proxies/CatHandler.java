package ru.clevertec.ReflectionApi.proxies;

import ru.clevertec.ReflectionApi.cat.CatInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CatHandler implements InvocationHandler {

    private CatInterface catInterface;

    public CatHandler(CatInterface catInterface) {
        this.catInterface = catInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** CatHandler has just handled this calling. ***");
        return method.invoke(catInterface, args);
    }
}
