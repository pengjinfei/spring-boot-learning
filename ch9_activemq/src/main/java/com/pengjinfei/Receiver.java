package com.pengjinfei;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Pengjinfei on 16/9/13.
 * Description:
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接收到：<"+message+">");
    }
}
