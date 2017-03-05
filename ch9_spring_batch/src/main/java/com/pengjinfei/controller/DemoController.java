package com.pengjinfei.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
@RestController
public class DemoController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job importJob;

    public JobParameters jobParameters;

    @RequestMapping("/imp")
    public String imp(HttpServletRequest request) throws Exception {
        String path=request.getParameter("fileName")+".csv";
        String excel = request.getParameter("excel");
        jobParameters=new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("input.file.name",path)
                .addString("excel.name",excel)
                .toJobParameters();
    jobLauncher.run(importJob,jobParameters);
        return "OK";
    }
}
