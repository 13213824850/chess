package com.onlinechese.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.onlinechese.componet.GameStartWs;
import com.onlinechese.componet.WsHandler;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSocket
@Slf4j
public class WsConfigure implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		log.info("请求连接");
		registry.addHandler(myHandler(), "/websocket/{id}").setAllowedOrigins("*");
		registry.addHandler(geGameStartWs(), "/game/{id}").setAllowedOrigins("*");
	}

	@Bean
	public WsHandler myHandler() {
		return new WsHandler();
	}
	@Bean 
	GameStartWs geGameStartWs() {
		return new GameStartWs();
	}
	
}
