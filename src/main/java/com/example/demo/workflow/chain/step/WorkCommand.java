package com.example.demo.workflow.chain.step;

import com.example.demo.workflow.chain.BaseCommand;
import com.example.demo.workflow.chain.GroovyExpressionEngine;
import org.apache.commons.chain.Context;

public class WorkCommand extends BaseCommand {

    public WorkCommand() {
        super.setExpression("!context.isHoliday");
        super.setScriptEngine(new GroovyExpressionEngine());
    }

    @Override
    public boolean action(Context context) throws Exception {
        log.info(" WorkCommand ...............");
        return false;
    }
}
