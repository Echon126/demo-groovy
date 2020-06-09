package com.example.demo.job;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DemoTest {
    public static void main(String[] args) throws IOException {

        List<JobData> nameList = Arrays.asList
                (new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test001.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test002.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test003.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test004.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test005.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test006.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test007.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test008.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test009.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test010.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test011.txt"),
                new JobData("AAAAAAAAAAABBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCDDDDDDDDDDDDDDDDDDDDDDEEEEEEyyyyyyyyyyy\r", new Date(), "test012.txt"));
        // 模拟多个任务
        List<Supplier<String>> supplierList = nameList.stream()
                .map(item -> new bus().toSupplier(item))
                .collect(Collectors.toList());
        // 并发执行多个任务
        List<String> result = ThreadHelper.getTaskResult(2, supplierList);
        System.out.println(result);
        Vector<FileInputStream> vector = new Vector<>();

        for (String f : result) {
            vector.add(new FileInputStream(f));
        }
        Enumeration<FileInputStream> elements = vector.elements();
        SequenceInputStream sis = new SequenceInputStream(elements);

        File file = new File("D:\\data111\\" + "final.txt");
        FileUtils.forceMkdirParent(file);
        FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile());
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = sis.read(b)) != -1) {
            // 写
            fos.write(b, 0, len);
        }
        // 关闭资源
        fos.close();
        sis.close();
    }


}
