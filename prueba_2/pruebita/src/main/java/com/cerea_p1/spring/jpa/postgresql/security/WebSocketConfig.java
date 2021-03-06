package com.cerea_p1.spring.jpa.postgresql.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.SimpMessageType;



@Configuration
@EnableWebSocketMessageBroker
@Deprecated
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        messages
                .simpTypeMatchers(SimpMessageType.CONNECT,
                        SimpMessageType.DISCONNECT, SimpMessageType.OTHER, SimpMessageType.SUBSCRIBE, SimpMessageType.MESSAGE, SimpMessageType.UNSUBSCRIBE).permitAll()
                .anyMessage().permitAll();
    }
 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/user");
        config.setApplicationDestinationPrefixes("/game");
    }
 
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // custom heartbeat, every 60 sec
        registry.addEndpoint("/onep1-game").setAllowedOriginPatterns("*").withSockJS();
    }
}
