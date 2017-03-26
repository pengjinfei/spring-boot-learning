package com.pengjinfei.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.pengjinfei.mybatis.domain.JobInstance;
import com.pengjinfei.mybatis.mapper.JobInstanceMapper;
import com.pengjinfei.mybatis.service.JobInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pengjinfei on 2017/3/26.
 * Description:
 */
@Service
public class JobInstanceServiceImpl implements JobInstanceService {

    @Autowired
    JobInstanceMapper jobInstanceMapper;

    @Override
    public List<JobInstance> selectByPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        return jobInstanceMapper.selectAll();
    }
}
