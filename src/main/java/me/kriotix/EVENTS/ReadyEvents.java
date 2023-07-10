package me.kriotix.EVENTS;

import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class ReadyEvents implements EventListener {
    @Override
    public void onEvent(GenericEvent event) {
        if(event instanceof ReadyEvent)
            System.out.println("Bot is online!");
    }
}
