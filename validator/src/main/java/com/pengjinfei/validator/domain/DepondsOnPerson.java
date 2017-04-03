package com.pengjinfei.validator.domain;

import com.pengjinfei.validator.service.PersonConstraint;
import lombok.Data;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Data
public class DepondsOnPerson {
    @PersonConstraint
    private Person person;
}
