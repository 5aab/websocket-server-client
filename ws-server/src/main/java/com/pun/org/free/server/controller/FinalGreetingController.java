package com.pun.org.free.server.controller;

import com.google.common.base.Strings;
import com.pun.org.free.server.message.Greeting;
import com.pun.org.free.server.message.HelloMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Collections;

@Slf4j
@Controller
@AllArgsConstructor
public class FinalGreetingController {

    private static String sessionId= "";
    private SimpMessageSendingOperations messagingTemplate;


    @MessageMapping("/confirm")
    @SendTo("/queue/reply")
    public Greeting greeting(HelloMessage message, @AuthenticationPrincipal Jwt principal, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
        log.info("Session Id {}", sessionId);
        log.info("Here is the principle {} {}", principal, headerAccessor);
        log.info("Add a delay of second {}", message);
        Thread.sleep(1000); // simulated delay
        return Greeting.create("Hello, " , HtmlUtils.htmlEscape(message.getName()) + "! - with love from Server");
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessage(){
        if (!Strings.isNullOrEmpty(sessionId)){
            messagingTemplate.convertAndSend("/queue/reply", Greeting.create(" Rolex Watch & Co." , HtmlUtils.htmlEscape(String.valueOf(System.currentTimeMillis()%1_000_000))), Collections.singletonMap(SimpMessageHeaderAccessor.SESSION_ID_HEADER, sessionId));
        }
    }

}
