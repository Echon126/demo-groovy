package com.example.demo.groovy;

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
    private static String[] root = new String[]{"bin/groovy/"};
    private static GroovyScriptEngine groovyScriptEngine;

    static {
        try {
            groovyScriptEngine = new GroovyScriptEngine(root);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("创建groovy执行引擎时发生异常", e);
        }
    }


    public static Object invokeMethod(String scriptName, String methodName, Object... params) throws Exception {
        Object ret;
        Class scriptClass;
        GroovyObject scriptInstance;

        try {
            scriptClass = groovyScriptEngine.loadScriptByName(scriptName);
            scriptInstance = (GroovyObject) scriptClass.newInstance();
        } catch (ResourceException | ScriptException | InstantiationException | IllegalAccessException e1) {
            log.warn("加载脚本[" + scriptName + "]出现异常", e1);
            throw new Exception("加载脚本" + scriptName + "失败");
        }

        try {
            ret = scriptInstance.invokeMethod(methodName, params);
        } catch (IllegalArgumentException e) {
            log.warn("执行方法" + methodName + "参数出现异常, 参数为" + params, e);
            throw new Exception("调用方法[" + methodName + "]失败，因参数不合法");
        } catch (Exception e) {
            log.warn("执行方法" + methodName + "出现异常", e);
            throw new Exception("调用方法[" + methodName + "]失败");
        }

        return ret;
    }
}
