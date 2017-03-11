package com.pengjinfei.mybatis.controller;

import com.pengjinfei.mybatis.domain.BatchJobExecution;
import com.pengjinfei.mybatis.mapper.BatchJobExecutionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by Pengjinfei on 2017/3/11.
 * Description:
 */
@RestController
public class JobController {

    @Autowired
    BatchJobExecutionMapper batchJobExecutionMapper;

    @RequestMapping(value = "/jobs/{str}",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public BatchJobExecution demoPathVar(@PathVariable("str") String str, HttpServletRequest request) {
        return batchJobExecutionMapper.selectByPrimaryKey(new BigDecimal(str));
    }
}
