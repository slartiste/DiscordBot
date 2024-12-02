package com.example.discordbot;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDAConfig {

    @Value("${discord.bot.token}")
    private String botToken;

    @Bean
    public JDA jda() throws Exception {
        // Ensure the botToken is not null and trimmed before being passed
        if (botToken == null || botToken.trim().isEmpty()) {
            throw new IllegalStateException("Bot token is not set or is empty.");
        }

        return JDABuilder.createDefault(botToken.trim())
                .build();
    }
}