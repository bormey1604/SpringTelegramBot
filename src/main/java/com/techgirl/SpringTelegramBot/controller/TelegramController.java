package com.techgirl.SpringTelegramBot.controller;

import com.techgirl.SpringTelegramBot.model.Message;
import com.techgirl.SpringTelegramBot.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TelegramController {
    @Autowired
    private TelegramService telegramService;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        String msg = message.getTitle() + "\n" + message.getMessage();
        telegramService.sendMessage(msg);
        return ResponseEntity.ok("Message sent");
    }
}
