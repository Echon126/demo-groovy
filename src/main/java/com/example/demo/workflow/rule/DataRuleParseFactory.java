package com.example.demo.workflow.rule;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataRuleParseFactory implements ApplicationContextAware {
    private static Map<String, DataRuleParse> dataRuleParseMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, DataRuleParse> map = applicationContext.getBeansOfType(DataRuleParse.class);
        dataRuleParseMap = new HashMap<>();
        map.forEach((k, v) -> {
            dataRuleParseMap.put(v.getRuleType().toString(), v);
        });
    }

    @SuppressWarnings("unchecked")
    public static <T extends DataRuleParse> T getTrafficMode(String ruleType) {
        return (T) dataRuleParseMap.get(ruleType);
    }
}
