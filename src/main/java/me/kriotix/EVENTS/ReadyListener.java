/*
 * File: ReadyListener.java
 * Author: Kriotix
 * Last modified: 7/16/2023
 * Purpose: Listens for the bot coming online & outputs to console.
 * */

package me.kriotix.EVENTS;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter{
    @Override
    public void onReady(ReadyEvent event) {
        if(event instanceof ReadyEvent)
            System.out.println("Bot is online!");
    }
}
