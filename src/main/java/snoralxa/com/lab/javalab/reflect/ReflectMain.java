package snoralxa.com.lab.javalab.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 0:38
 */
public class ReflectMain {
    public static void main(String[] args) {
        People zhagnsan = new People("张三");
        zhagnsan.sayHello();
        // 要知道张三的年龄怎么办？

        // 反射
        try {
            Class<?> peopleClass = Class.forName("snoralxa.com.lab.javalab.reflect.People");

            Method sayAge = peopleClass.getDeclaredMethod("sayAge");
            // 把私有方法设定为可访问
            sayAge.setAccessible(true);
            // 传入张三，强迫他说出年龄
            sayAge.invoke(zhagnsan);

            // 抓走张三关进小黑屋，强行修改他的地址
            Field address = peopleClass.getDeclaredField("address");
            address.setAccessible(true);
            address.set(zhagnsan, "xxx路小黑屋");
            String zhagnsanAddress = (String) address.get(zhagnsan);
            System.out.println("张三现在在：" + zhagnsanAddress);

            // 复克隆一个张三
            People zhagnsanCloned = (People) peopleClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
