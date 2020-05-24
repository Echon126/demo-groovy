package com.example.demo.workflow.rule.impl;

import com.example.demo.service.FlowService;
import com.example.demo.workflow.rule.DataRuleParse;
import com.example.demo.workflow.rule.RuleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Command implements DataRuleParse {

    @Autowired
    FlowService flowService;

    @Override
    public RuleType getRuleType() {
        return RuleType.MYRULEBYID1;
    }

    @Override
    public List<String> getSql(Map<String, Object> paramMap) {
        System.out.println("MYRULEBYID1");
        flowService.breakfast();
        return null;
    }
}
