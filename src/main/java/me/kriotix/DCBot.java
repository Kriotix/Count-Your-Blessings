/*
 * File: DCBot.java
 * Author: Kriotix
 * Last modified: 7/10/2023
 * Purpose: This bot allows the user to set a channel where a count will be kept track of.
 * This count is a streak that can be broken if the corresponding message is not the next in the sequence.
 * */

package me.kriotix;
import me.kriotix.EVENTS.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class DCBot {
    public static void main(String[] args){
        //Bot token & builder
        JDABuilder bot = JDABuilder.createDefault("MTEyNjM2MjkzNTE5MTY2NjcxOQ.GbSatu.C_gCRR17dnir1Gu_inn8q5q9staztsZyliw-Ss");

        bot
                .setActivity(Activity.playing("Pixlies Earth!"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new ReadyEvents(), new MessageEvents()).build();
    }
}