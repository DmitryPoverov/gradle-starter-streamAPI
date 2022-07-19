package ru.clevertec.ReflectionApi;

import ru.clevertec.ReflectionApi.cat.Cat;
import ru.clevertec.ReflectionApi.cat.CatInterface;
import ru.clevertec.ReflectionApi.proxies.CatHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyRunner {

    public static void main(String[] args) throws Throwable {

        CatInterface cat = new Cat();
        ClassLoader catClassLoader = cat.getClass().getClassLoader();
        Class<?>[] catInterfaces = cat.getClass().getInterfaces();

        CatInterface proxyCat = (CatInterface) Proxy.newProxyInstance(catClassLoader, catInterfaces, new CatHandler(cat));
        String catPublic = proxyCat.catPublic();
        System.out.println(catPublic);

/* I got an array of interfaces of super-class and sub-class and took it to the console.
        Class<?>[] animalInterfaces = catClass.getSuperclass().getInterfaces();
        Arrays.stream(animalInterfaces).forEach(catInterface-> System.out.println(catInterface.getSimpleName()));
        Arrays.stream(catInterfaces).forEach(catInterface-> System.out.println(catInterface.getSimpleName()));*/
/* I tried to invoke method 'invoke()' at a catHandler instance without a proxy-object
        CatHandler catHandler = new CatHandler(cat);
        Method catPublic = cat.getClass().getDeclaredMethod("catPublic");
        Object[] catArgs = new Object[0];
        catHandler.invoke(cat, catPublic, catArgs);*/
    }
}
