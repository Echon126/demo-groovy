package com.example.demo.interfaces;

import com.example.demo.entity.MonitorInfo;

import java.util.List;

public interface MonitoringService {

    @SuppressWarnings("unchecked")
    public void submitMonitorInfo(MonitorInfo monitorInfo) {
        log.info("监控日志");
        redisTemplate.opsForHash().put("xxx", "xxx", "xxxx");
    }
    //提交监控信息
    void submit(String mid, MonitorInfo monitorInfo);

    //获取监控信息列表
    List<MonitorInfo> list(String mid);

    public static void main(String[] args) throws IOException {
        //解析Groovy模板文件
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap(128);
        final String path = "classpath*:*.groovy_template";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Arrays.stream(resolver.getResources(path))
                .parallel()
                .forEach(resource -> {
                    try {
                        String fileName = resource.getFilename();
                        InputStream input = resource.getInputStream();
                        InputStreamReader reader = new InputStreamReader(input);
                        BufferedReader br = new BufferedReader(reader);
                        StringBuilder template = new StringBuilder();
                        for (String line; (line = br.readLine()) != null; ) {
                            template.append(line).append("\n");
                        }
                        concurrentHashMap.put(fileName, template.toString());
                    } catch (Exception e) {
                        log.error("resolve file failed", e);
                    }
                });
        String scriptBuilder = concurrentHashMap.get("groovy_template.groovy_template");
        String scriptClassName = "testGroovy";
        //这一部分String的获取逻辑进行可配置化
        String nextScenario = "if(context.a<=10000){\n" +
                "return true\n" +
                "}\n" +
                "";
        String StrategyLogicUnit = "if(context.amount>=20000){\n" +
                "            context.nextScenario=\n" + nextScenario +
                "            return true\n" +
                "        }\n" +
                "        ";
        String fullScript = String.format(scriptBuilder, scriptClassName, StrategyLogicUnit);

        System.out.println(fullScript);
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class<EngineGroovyModuleRule> aClass = classLoader.parseClass(fullScript);
        Context context = new Context();
        context.setAmount(30000);
        try {
            EngineGroovyModuleRule engineGroovyModuleRule = aClass.newInstance();
            log.info("Groovy Script returns:{} ", engineGroovyModuleRule.run(context));
            String nextScenario1 = context.getNextScenario();
            log.info("Next Scenario is {}", nextScenario1);
            fullScript = nextScenario;
            aClass = classLoader.parseClass(fullScript);
            engineGroovyModuleRule = aClass.newInstance();
            Context context1 = new Context();
            context1.setAmount(30000);
            log.info("Groovy Script returns:{} ", engineGroovyModuleRule.run(context1));
        } catch (Exception e) {
            log.error("error...");
        }
    }
    //获取单个监控信息
    MonitorInfo monitorInfo(String mid, String hashKey);

    //删除监控信息
    Long delete(String mid, String key, String hashKey);
}
