/*
 * File: SetChannel.java
 * Author: Kriotix
 * Last modified: 7/10/2023
 * Purpose: Manages the setChannelCommand for the "Count Your Blessings" discord bot
 * */

package me.kriotix.EVENTS.MESSAGEEVENTS;

import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class SetChannel extends ListenerAdapter{
    public GuildChannel setChannelCommand (MessageReceivedEvent event) {

        //Was it necessary to use a list? Unsure. Did it work? Yes. If it ain't broke, don't fix it.
        List<GuildChannel> mentionedChannels = event.getMessage().getMentions().getChannels();

        //So if there wasn't a channel mentioned, the list will be empty. That's why this works.
        if (!mentionedChannels.isEmpty()) {
            event.getChannel().sendMessage("Channel set successfully!").queue();

            //And thus, since it isn't empty, it will take the first held value.
            return mentionedChannels.get(0);
        } else {
            event.getChannel().sendMessage("Invalid channel specified. Make sure the spelling & tagging is correct.").queue();
            return null;
        }
    }
    
    
}
