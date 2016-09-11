package com.pengjinfei.ch8.redis.domain;

import java.io.Serializable;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public class Person implements Serializable {
    private String id;
    private String name;
    private Integer age;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
