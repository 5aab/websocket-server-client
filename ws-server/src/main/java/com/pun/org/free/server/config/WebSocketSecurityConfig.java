package com.pun.org.free.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Order(Ordered.HIGHEST_PRECEDENCE+50)
@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry registry) {
        registry
                .nullDestMatcher().permitAll()
               // .simpTypeMatchers(SimpMessageType.MESSAGE).denyAll()
                .simpDestMatchers("/*").permitAll()
                .simpSubscribeDestMatchers("/*").permitAll()
                .anyMessage().permitAll();
    }

    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }

}
