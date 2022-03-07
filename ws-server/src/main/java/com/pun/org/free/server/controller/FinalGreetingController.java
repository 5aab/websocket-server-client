package com.pun.org.free.server.controller;

import com.pun.org.free.server.message.Greeting;
import com.pun.org.free.server.message.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Slf4j
@Controller
public class FinalGreetingController {


    @MessageMapping("/secured/confirm")
    @SendTo("/queue/reply")
    public Greeting greeting(HelloMessage message, Principal principal) throws Exception {
        log.info("Add a delay of second {}", message);
        log.info("Here is the principle {}", principal);
        Thread.sleep(1000); // simulated delay
        return Greeting.create("Hello, " , HtmlUtils.htmlEscape(message.getName()) + "! - with love from Server");
    }

}
