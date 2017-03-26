package com.pengjinfei.mybatis.service;

import com.pengjinfei.mybatis.domain.JobInstance;

import java.util.List;

/**
 * Created by Pengjinfei on 2017/3/26.
 * Description:
 */
public interface JobInstanceService {

    List<JobInstance> selectByPage(int page, int rows);
}
