package com.techgirl.SpringTelegramBot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TelegramService {
    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${telegram.chat.id}")
    private String chatId;
    private final WebClient webClient;


    public TelegramService() {
        this.webClient = WebClient.builder().baseUrl("https://api.telegram.org").build();
    }

    public String sendMessage(String message){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/bot{token}/sendMessage")
                        .queryParam("chat_id",chatId)
                        .queryParam("text",message)
                        .build(botToken))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
