package com.xyj;

import com.rwg.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * @author rwg
 * @date 2021/11/19 17:15
 */

@Slf4j
public class JunitTest extends BaseTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testRedisSerializer(){
        User user = new User();
        user.setName("java");
        user.setPwd("male");
        redisTemplate.opsForHash().put("user:","1",user);
        /*查看redisTemplate 的Serializer*/
        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(redisTemplate.getValueSerializer());

        /*查看StringRedisTemplate 的Serializer*/
        System.out.println(stringRedisTemplate.getValueSerializer());
        System.out.println(stringRedisTemplate.getValueSerializer());

        /*将stringRedisTemplate序列化类设置成RedisTemplate的序列化类*/
        stringRedisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        stringRedisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        /*即使在更换stringRedisTemplate的的Serializer和redisTemplate一致的
         * JdkSerializationRedisSerializer
         * 最后还是无法从redis中获取序列化的数据
         * */
        System.out.println(stringRedisTemplate.getValueSerializer());
        System.out.println(stringRedisTemplate.getValueSerializer());

        User user1 = (User)  redisTemplate.opsForHash().get("user:","1");
        User  user2 = (User) stringRedisTemplate.opsForHash().get("user:","1");
        System.out.println("dsd");
    }
}
