package com.pengjinfei.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
public class CsvJobListner implements JobExecutionListener {

    private Logger logger = LoggerFactory.getLogger(CsvJobListner.class);

    private long startTime;
    private long endTime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime= System.currentTimeMillis();
        logger.info("任务开始处理");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime= System.currentTimeMillis();
        logger.info("任务处理完成");
        logger.info("耗时：" +(endTime - startTime) + "ms");
    }
}
