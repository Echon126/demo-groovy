package com.example.demo.workflow.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public abstract class BaseCommand implements Command {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private String expression;
    private ScriptEngine scriptEngine;

    @Override
    public boolean execute(Context context) throws Exception {
        if (this.isRunnable(context)) {
            return this.action(context);
        }
        return false;
    }

    private boolean isRunnable(Context context) {
        if (!StringUtils.hasText(this.expression))
            return true;
        return (Boolean) scriptEngine.run(this.expression, context);
    }

    public void setScriptEngine(ScriptEngine scriptEngine) {
        this.scriptEngine = scriptEngine;

    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public abstract boolean action(Context context) throws Exception;


}
