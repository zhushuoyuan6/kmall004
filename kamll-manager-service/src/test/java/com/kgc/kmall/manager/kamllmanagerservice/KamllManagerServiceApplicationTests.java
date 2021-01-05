package com.kgc.kmall.manager.kamllmanagerservice;




import com.kgc.kmall.manager.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;


@SpringBootTest
class KamllManagerServiceApplicationTests {
	@Resource
	RedisUtil redisUtil;
	@Test
	void contextLoads() {
        Jedis jedis = redisUtil.getJedis();
        String ping = jedis.ping();
        System.out.println(ping);
    }

}
