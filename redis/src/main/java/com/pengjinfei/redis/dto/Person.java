package com.pengjinfei.redis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 7/22/17
 *
 * @author Pengjinfei
 */
@Data
@NoArgsConstructor
public class Person implements Serializable{
    private String name;
    private Integer id;
}
