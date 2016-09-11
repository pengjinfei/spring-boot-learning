package com.pengjinfei.ch4.domain;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class DemoObj {

    private Long id;

    private String name;

    public DemoObj() {
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
