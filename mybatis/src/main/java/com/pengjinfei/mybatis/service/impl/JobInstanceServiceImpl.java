package com.pengjinfei.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.pengjinfei.mybatis.domain.JobInstance;
import com.pengjinfei.mybatis.mapper.JobInstanceMapper;
import com.pengjinfei.mybatis.service.JobInstanceService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pengjinfei on 2017/3/26.
 * Description:
 */
@Service
@EnableTransactionManagement
public class JobInstanceServiceImpl implements JobInstanceService {

    @Autowired
    JobInstanceMapper jobInstanceMapper;

    @Autowired
    SqlSessionTemplate batchSqlSession;

    @Override
    public List<JobInstance> selectByPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        return jobInstanceMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void batchInsert(List<JobInstance> jobInstances) {
        JobInstanceMapper mapper = batchSqlSession.getMapper(JobInstanceMapper.class);
        for (JobInstance jobInstance : jobInstances) {
            mapper.insertSelective(jobInstance);
        }
    }

    @Override
    public int insert(JobInstance jobInstance) {
        return jobInstanceMapper.insertSelective(jobInstance);
    }

}
