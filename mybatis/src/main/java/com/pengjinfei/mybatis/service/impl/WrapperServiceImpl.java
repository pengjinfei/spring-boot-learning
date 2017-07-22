package com.pengjinfei.mybatis.service.impl;

import com.pengjinfei.mybatis.domain.JobInstance;
import com.pengjinfei.mybatis.service.JobInstanceService;
import com.pengjinfei.mybatis.service.WrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pengjinfei on 6/1/17.
 * Description:
 */
@Service
public class WrapperServiceImpl implements WrapperService {

    @Autowired
    JobInstanceService jobInstanceService;

    @Override
    @Transactional
    public void batchInsert(List<JobInstance> jobInstances) {
        JobInstance jobInstance=new JobInstance();
        jobInstance.setVersion(123);
        jobInstance.setJobKey("goodb2");
        jobInstance.setJobName("goodb2");
        jobInstanceService.insert(jobInstance);
        jobInstanceService.batchInsert(jobInstances);
    }
}
