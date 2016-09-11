package com.pengjinfei.ch4.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Service
public class PushService {

    private DeferredResult<String > deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(String.valueOf(new Long(System.currentTimeMillis())));
        }
    }
}
