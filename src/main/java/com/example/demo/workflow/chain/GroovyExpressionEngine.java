package com.example.demo.workflow.chain;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

public class GroovyExpressionEngine implements ScriptEngine {
    @Override
    public Object run(String express, Object context) {
        ClassLoader cl = GroovyExpressionEngine.class.getClassLoader();
        GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
        Class groovyClass = groovyCl.parseClass(express);
        Script sc;
        try {
            sc = (Script) groovyClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        Binding binding = new Binding();
        binding.setVariable("context", context);
        sc.setBinding(binding);
        return sc.run();
    }

    public static void main(String[] args) {
        GroovyExpressionEngine groovyExpressionEngine = new GroovyExpressionEngine();
        Context context = new ContextBase();
        context.put("isHoliday",true);
        Boolean run = (Boolean) groovyExpressionEngine.run("!context.isHoliday", context);
        System.out.println(run);
    }
}
