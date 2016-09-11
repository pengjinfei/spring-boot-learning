package com.pengjinfei.ch7.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Controller
@SpringBootApplication
public class WsApplication {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public Response say(Message message) throws Exception {
        Thread.sleep(3000);
        return new Response("Welcome, " + message.getName() + "!");
    }

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("jim")) {
            messagingTemplate.convertAndSendToUser("bob", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("jim","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(WsApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
