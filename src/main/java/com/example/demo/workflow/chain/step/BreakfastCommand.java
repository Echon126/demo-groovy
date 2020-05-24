package com.example.demo.workflow.chain.step;

import com.example.demo.service.FlowService;
import com.example.demo.workflow.chain.BaseCommand;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BreakfastCommand extends BaseCommand {

    @Autowired
    private FlowService flowService;

    @Override
    public boolean action(Context context) throws Exception {
        context.put("isHoliday", true);
        flowService.breakfast();
        return false;
    }

}
