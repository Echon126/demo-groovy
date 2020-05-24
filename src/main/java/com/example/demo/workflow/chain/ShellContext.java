package com.example.demo.workflow.chain;

import org.apache.commons.chain.impl.ContextBase;

public class ShellContext extends ContextBase {
    private Integer times;
    private String isHoliday;

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(String isHoliday) {
        this.isHoliday = isHoliday;
    }
}
