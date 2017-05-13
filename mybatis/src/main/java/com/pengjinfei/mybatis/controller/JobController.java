package com.pengjinfei.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.pengjinfei.mybatis.domain.JobInstance;
import com.pengjinfei.mybatis.mapper.BatchJobExecutionMapper;
import com.pengjinfei.mybatis.service.JobBaseService;
import com.pengjinfei.mybatis.service.JobInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Pengjinfei on 2017/3/11.
 * Description:
 */
@RestController
public class JobController {

    @Autowired
    BatchJobExecutionMapper batchJobExecutionMapper;
    @Autowired
    JobInstanceService jobInstanceService;

    @Autowired
    JobBaseService jobBaseService;

    @RequestMapping(value = "/job/{str}")
    public JobInstance demoPathVar(@PathVariable("str") String str, HttpServletRequest request) {
        return jobBaseService.get(str);
    }


    @GetMapping("/jobs")
    public PageInfo<JobInstance> getAll(@RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int rows)
    {
        List<JobInstance> jobInstances = jobBaseService.selectByPage(page, rows);
        return  new PageInfo<>(jobInstances);
    }

    @GetMapping("/base/jobs")
    public PageInfo<JobInstance> getAllByBase(@RequestParam(required = false, defaultValue = "1") int page,
                                        @RequestParam(required = false, defaultValue = "10") int rows)
    {
        List<JobInstance> jobInstances = jobInstanceService.selectByPage(page, rows);
        return  new PageInfo<>(jobInstances);
    }
}
