package com.example.demo.workflow.rule;

import java.util.List;
import java.util.Map;

public interface DataRuleParse {

    RuleType getRuleType();

    List<String> getSql(Map<String,Object> paramMap);
}
