package com.example.demo.utils;

import com.example.demo.entity.Person;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * @author 25144
 */
public class TestGroovy {

    public static void main(String[] args) throws Exception {
//        // 使用当前线程的context创建GroovyClassLoader
//        // parseClass()方法将文件解析成可以运行的class
//        Class aClass = new GroovyClassLoader().parseClass(new File("D:\\devops\\work-space\\demo-groovy\\src\\main\\resources\\groovy\\AssemblyCommand.groovy"));
//        // 创建此 Class 对象所表示的类的一个新实例
//        GroovyObject groovyObject = (GroovyObject) aClass.newInstance();
//        // groovy 方法的入参，多个参数从左到右书写，无入参保持为空new Object[]{}
//        Object[] objects = new Object[]{"XXXXXXXXX", "CCCCCCCC"};
//        // 调用方法 testC 并获得返回值(如果后者存在)
//        System.out.println(groovyObject.invokeMethod("create", objects));
//

        //无参数调用
        String result = (String) GroovyCommonUtil.invokeMethod("test-002.groovy", "helloWithoutParam");
        System.out.println("testGroovy4: " + result + "\n");

        Person person = new Person("wchi", "nanjing", 30);
        String result1 = (String) GroovyCommonUtil.invokeMethod("test-002.groovy", "helloWithParam", person, "testGroovy4");
        System.out.println("testGroovy4: " + result1 + "\n");
    }
}
