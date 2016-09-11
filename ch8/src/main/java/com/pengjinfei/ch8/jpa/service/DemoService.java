package com.pengjinfei.ch8.jpa.service;

import com.pengjinfei.ch8.jpa.domain.Person;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);

    Person saveUseCache(Person person);

    void removeUseCache(Long id);

    Person findOne(Person person);
}
