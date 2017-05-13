package com.pengjinfei.mybatis.service;

import com.pengjinfei.mybatis.domain.JobInstance;
import com.pengjinfei.mybatis.mapper.JobInstanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * Created by Pengjinfei on 2017/5/2.
 * Description:
 */
@Service
public class JobBaseService extends BaseService<JobInstance>{

    @Autowired
    JobInstanceMapper jobInstanceMapper;

    public JobInstance get(String  str) {
        Example example = new Example(JobInstance.class);
        example.createCriteria().andEqualTo("jobInstanceId", str);
        return jobInstanceMapper.selectByExample(example).get(0);
    }
}
