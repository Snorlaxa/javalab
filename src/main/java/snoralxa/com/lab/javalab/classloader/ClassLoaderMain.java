package snoralxa.com.lab.javalab.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 1:22
 */
public class ClassLoaderMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String path = "D:\\work\\Projects\\javalab\\target\\classes\\";
        // 内部有package的必须使用全路径名
        String name = "snoralxa.com.lab.javalab.reflect.People";
        MyClassloader myClassloader = new MyClassloader(path, "MyClassloader");
        Class<?> peopleClass = myClassloader.findClass(name);
        Method method = peopleClass.getDeclaredMethod("sayAge");
        method.setAccessible(true);
        method.invoke(peopleClass.newInstance());
    }
}
