package com.pengjinfei.validator.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Pengjinfei on 2017/4/2.
 * Description:
 */
@Data
public class Person {

    @Length(min = 5)
    private String name;
    private Integer age;

    private Boolean man;

    private Student student;
}
