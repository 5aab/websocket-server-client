package com.pun.org.free.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

@Slf4j
public class StompClient {

    private static String URL = "ws://localhost:9090/gs-guide-websocket";

    public static void main(String[] args) {
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

       // stompClient.connect(URL, new MyStompSessionHandler());
        stompClient.connect(URL, new MyStompSessionHandlerForPrinciple());

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            log.info("Next Line: {}",nextLine);
        }
    }
}
