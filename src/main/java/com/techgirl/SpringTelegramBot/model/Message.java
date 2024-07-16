package com.techgirl.SpringTelegramBot.model;

import com.google.gson.Gson;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Message {
    private String message;
    private String title;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
