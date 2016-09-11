package com.pengjinfei.ch8.jpa.support;

import com.pengjinfei.ch8.jpa.specs.CustomerSpecs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager=em;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(CustomerSpecs.byAuto(entityManager,example),pageable);
    }
}
