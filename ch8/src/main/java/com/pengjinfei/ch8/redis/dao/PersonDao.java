package com.pengjinfei.ch8.redis.dao;

import com.pengjinfei.ch8.redis.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Repository
public class PersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String ,String > valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void StringRedisTemplateDemo() {
        valOpsStr.set("xx","yy");
    }

    public void save(Person person) {
        valOps.set(person.getId(),person);
    }

    public String getString() {
        return valOpsStr.get("xx");
    }

    public Person getPerson() {
        return (Person) valOps.get("1");
    }
}
