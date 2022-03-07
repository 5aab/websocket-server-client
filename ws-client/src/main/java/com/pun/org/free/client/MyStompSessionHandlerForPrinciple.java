package com.pun.org.free.client;

import com.pun.org.free.client.message.Greeting;
import com.pun.org.free.client.message.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;


@Slf4j
public class MyStompSessionHandlerForPrinciple extends StompSessionHandlerAdapter {

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        log.info("New session established : " + session.getSessionId());

        session.subscribe("/queue/reply", this);
        log.info("Subscribed to /queue/reply");

        session.send("/app/confirm", getSampleMessage());
        log.info("Message sent to websocket server for principle");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Greeting.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Greeting msg = (Greeting) payload;
        log.info("Received : " + msg.getText() + " from : " + msg.getFrom());
    }

    private HelloMessage getSampleMessage() {
        return HelloMessage.create("is it you u", "Server!!");
    }
}
