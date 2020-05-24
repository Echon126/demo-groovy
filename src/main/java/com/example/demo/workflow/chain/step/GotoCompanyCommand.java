package com.example.demo.workflow.chain.step;

import com.example.demo.workflow.chain.BaseCommand;
import com.example.demo.workflow.chain.GroovyExpressionEngine;
import org.apache.commons.chain.Context;

public class GotoCompanyCommand extends BaseCommand {
    public GotoCompanyCommand() {
        super.setExpression("!context.isHoliday");
        super.setScriptEngine(new GroovyExpressionEngine());
    }

    @Override
    public boolean action(Context context) throws Exception {

        log.info(" GotoCompanyCommand ...............");
        return false;
    }
}
