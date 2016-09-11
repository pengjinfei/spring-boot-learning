package com.pengjinfei.ch8.jpa.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);
}
