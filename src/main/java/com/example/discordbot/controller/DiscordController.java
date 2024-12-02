package com.example.discordbot.controller;

import com.example.discordbot.service.DiscordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscordController {
    private final DiscordService discordService;

    public DiscordController(DiscordService discordService) {
        this.discordService = discordService;
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        discordService.sendMessageToChannel("test-channel", "Test message");
        return "Message sent to test-channel!";
    }
}