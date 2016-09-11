package com.pengjinfei.ch3.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer integer) {
        System.out.println("执行异步任务： "+integer);
    }

    @Async
    public void executeAsyncTaskPlus(Integer integer) {
        System.out.println("执行异步任务+1 :"+(integer+1));
    }
}
