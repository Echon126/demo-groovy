package com.example.demo.utils;

import com.example.demo.entity.Person;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author 25144
 * <p>
 * https://www.cnblogs.com/jizha/p/5027695.html
 */
public class GroovyCommonUtil {
    private static final Logger log = LoggerFactory.getLogger(GroovyCommonUtil.class);
    /**
     * 该变量用于指明groovy脚本所在的父目录
     */
    static String root[] = new String[]{"bin/groovy/"};
    static GroovyScriptEngine groovyScriptEngine;

    static {
        try {
            groovyScriptEngine = new GroovyScriptEngine(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Object invokeMethod(String scriptName, String methodName, Object... params) throws Exception {
        Object ret = null;
        Class scriptClass = null;
        GroovyObject scriptInstance = null;

        try {
            scriptClass = groovyScriptEngine.loadScriptByName(scriptName);
            scriptInstance = (GroovyObject) scriptClass.newInstance();
        } catch (ResourceException | ScriptException | InstantiationException | IllegalAccessException e1) {
            log.warn("加载脚本[" + scriptName + "]出现异常", e1);
            throw new Exception("加载脚本" + scriptName + "失败");
        }

        try {
            ret = (String) scriptInstance.invokeMethod(methodName, params);
        } catch (IllegalArgumentException e) {
            log.warn("执行方法" + methodName + "参数出现异常, 参数为" + params, e);
            throw new Exception("调用方法[" + methodName + "]失败，因参数不合法");
        } catch (Exception e) {
            log.warn("执行方法" + methodName + "出现异常", e);
            throw new Exception("调用方法[" + methodName + "]失败");
        }

        return ret;
    }


    public static void main(String[] args) throws Exception {
        //无参数调用
        String result = (String) GroovyCommonUtil.invokeMethod("hello2.groovy", "helloWithoutParam");
        System.out.println("testGroovy4: " + result + "\n");

        Person person = new Person("wchi", "nanjing", 30);
        String result1 = (String) GroovyCommonUtil.invokeMethod("hello2.groovy", "helloWithParam", person, "testGroovy4");
        System.out.println("testGroovy4: " + result1 + "\n");
    }
}
