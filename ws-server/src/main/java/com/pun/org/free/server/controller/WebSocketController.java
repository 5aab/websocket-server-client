package com.pun.org.free.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;

import java.security.Principal;

@Slf4j
//@Controller
//@AllArgsConstructor
public class WebSocketController {

    //private SimpMessageSendingOperations messagingTemplate;
   // private ObjectMapper mapper;

    // @MessageMapping("/message")
    public void processMessageFromClient(@Payload String message, SimpMessageHeaderAccessor headerAccessor) {
        String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
        System.out.println(sessionId);
        headerAccessor.setSessionId(sessionId);
       // messagingTemplate.convertAndSend("/topic/reply", message + " - greeting from server");
    }

    @MessageMapping("/confirm")
    @SendToUser("/queue/reply")
    public String processMessageFromClient(@Payload String message) {
        Principal principal=null;
        log.info("Here is the principle {}", principal);
        //log.info("principle Name : {}", principal.getName());
        String name = message + " - confirmed by server";
        //messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", name);
        return name;
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}