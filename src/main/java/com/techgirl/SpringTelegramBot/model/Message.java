package com.techgirl.SpringTelegramBot.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Message {
    private String message;
    private String title;
}
