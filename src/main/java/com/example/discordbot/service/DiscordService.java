package com.example.discordbot.service;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {
    private final JDA jda;

    public DiscordService(JDA jda) {
        this.jda = jda;
    }

    public void sendMessageToChannel(String channelName, String message) {
        Guild guild = jda.getGuilds().get(0); // Assumes you're working with the first guild
        if (guild != null) {
            GuildMessageChannel channel = guild.getChannels()
                    .stream()
                    .filter(c -> c instanceof GuildMessageChannel)
                    .map(c -> (GuildMessageChannel) c)
                    .filter(c -> c.getName().equalsIgnoreCase(channelName))
                    .findFirst()
                    .orElse(null);
            if (channel != null) {
                channel.sendMessage(message).queue();
            } else {
                System.out.println("Channel not found: " + channelName);
            }
        } else {
            System.out.println("No guilds available for the bot.");
        }
    }
}