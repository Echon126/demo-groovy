package com.example.demo.workflow.rule.impl;

import com.example.demo.workflow.rule.DataRuleParse;
import com.example.demo.workflow.rule.RuleType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Inject implements DataRuleParse {
    @Override
    public RuleType getRuleType() {
        return RuleType.MYRULEBYID2;
    }

    @Override
    public List<String> getSql(Map<String, Object> paramMap) {
        System.out.println("MYRULEBYID2");
        return null;
    }
}
