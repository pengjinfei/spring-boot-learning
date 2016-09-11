package com.pengjinfei.ch8.jpa.service;

import com.pengjinfei.ch8.jpa.dao.PersonRepository;
import com.pengjinfei.ch8.jpa.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("del")) {
            throw new IllegalArgumentException("del已经存在，数据将回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor= {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("del")) {
            throw new IllegalArgumentException("del虽然已经存在，数据不回滚");
        }
        return p;
    }

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person saveUseCache(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id为："+p.getId()+"的数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void removeUseCache(Long id) {
        System.out.println("删除了id为："+id+"的缓存数据");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        Person one = personRepository.findOne(person.getId());
        System.out.println("为id为："+one.getId()+"的数据做了缓存");
        return one;
    }
}
