package com.example.demo;

import com.example.demo.config.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

    @Test
    public void test() {
        //加锁
        RedisLock.lock("ming");
        //继续加锁
        try {
            RedisLock.lock("ming",1l);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        //释放锁
        RedisLock.unLock("ming");
        //加锁
        log.info("再次加锁");
        RedisLock.lock("ming");
        log.info("加锁成功");
        RedisLock.unLock("ming");
        log.info("释放锁完成");

    }
}
