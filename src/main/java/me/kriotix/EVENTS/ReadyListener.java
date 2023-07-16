/*
 * File: ReadyListener.java
 * Author: Kriotix
 * Last modified: 7/16/2023
 * Purpose: Listens for the bot coming online & outputs to console.
 * */

package me.kriotix.EVENTS;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ReadyListener implements EventListener{
    @Override
    public void onEvent(GenericEvent event) {
        if(event instanceof ReadyEvent)
            System.out.println("Bot is online!");
    }
}
