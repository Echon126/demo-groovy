package com.example.demo.job;

import org.apache.commons.io.FileUtils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class bus {
    /**
     * 模拟将普通方法构建成Supplier方法
     */
    public Supplier<String> toSupplier(@NotNull JobData jobData) {
        return () -> this.writeJob(jobData);
    }

    /**
     * 模拟一个普通方法
     */
    public String writeJob(@NotNull JobData name) {
        System.out.println("task线程："+Thread.currentThread().getName()+"--------"+new Date());
        System.out.println(name.getFileName()+"--------------------" + new Date().getTime());
        File file = new File("D:\\data111\\" + name.getFileName());
        try {
            FileUtils.forceMkdirParent(file);
            file.createNewFile();
            TimeUnit.SECONDS.sleep(3);
            FileUtils.writeStringToFile(file, name.getMessage(), "utf-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
