package com.pengjinfei.ch3.taskExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class AsyncTaskService {

    private Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);

    @Async
    public void executeAsyncTask(Integer integer) {
        logger.info("执行异步任务： "+integer);
    }

    @Async
    public void executeAsyncTaskPlus(Integer integer)
    {
        logger.info("执行异步任务+1 :"+(integer+1));
    }
}
