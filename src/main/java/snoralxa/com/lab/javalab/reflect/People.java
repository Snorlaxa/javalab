package snoralxa.com.lab.javalab.reflect;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 0:33
 */
public class People {
    public String name;
    public String gender;
    private int age;
    private String address;

    public People(String name) {
        this.name = name;
        this.age = 20;
    }

    public People() {

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello I am " + name + ".");
    }

    private void sayAge() {
        System.out.println("I am " + age + " years old.");
    }
}
