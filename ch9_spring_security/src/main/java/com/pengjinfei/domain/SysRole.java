package com.pengjinfei.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public SysRole() {
    }

    public SysRole(String name) {
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
