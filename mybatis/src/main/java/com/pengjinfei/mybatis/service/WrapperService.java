package com.pengjinfei.mybatis.service;

import com.pengjinfei.mybatis.domain.JobInstance;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pengjinfei on 6/1/17.
 * Description:
 */
public interface WrapperService {
    @Transactional
    void batchInsert(List<JobInstance> jobInstances);
}
