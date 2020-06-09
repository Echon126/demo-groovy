package com.example.demo.job;

import java.util.Date;

public class JobData {

    private String message;
    private Date date;
    private String fileName;

    public JobData(String message, Date date, String fileName) {
        this.message = message;
        this.date = date;
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
