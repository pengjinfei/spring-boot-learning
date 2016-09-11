package com.pengjinfei.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class SchedulerTaskService {

    private final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行一次 "+dataFormat.format(new Date()));
    }

    @Scheduled(cron = "*/7 * * ? * *")
    public void cronExecution() {
        System.out.println("cron执行计划 "+dataFormat.format(new Date()));
    }
}
