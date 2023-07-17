/*
 * File: MessageListener.java
 * Author: Kriotix
 * Last modified: 7/16/2023
 * Purpose: Listens for messages & directs either SetChannel or Counter
 * based on input.
 * */

package me.kriotix.EVENTS;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import me.kriotix.EVENTS.MESSAGEEVENTS.*;

public class MessageListener extends ListenerAdapter {

    private int count = 0;
    private GuildChannel CHANNEL_ID;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Makes sure the message isn't the bot, otherwise it loops foreva
        if (event.getAuthor().isBot()){
            return;
        }

        super.onMessageReceived(event);

        //Grabs the content of the message & splits into a string array
        String[] splitMessage = event.getMessage().getContentRaw().split(" ");

        //Checking to see if the command was entered. Is not case-sensitive.
        if (splitMessage[0].equalsIgnoreCase("/setchannel")) {

            //Makes sure user isn't null
            if (event.getMember() == null) {
                return;
            }
            //Only admins can use this command
            if (event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {

                //Calls the setChannelCommand & sets channel id to the return value. This is checked later.
                SetChannel setChannel = new SetChannel();
                CHANNEL_ID = setChannel.setChannelCommand(event);
            }
            else {
                event.getChannel().sendMessage("You do not have permission to execute this command (Administrator required.)").queue();
            }

            //This check makes it so the count and /count command can only take place in the chosen channel
        } else if (event.getGuildChannel().equals(CHANNEL_ID)){

            //Accounts for case-sensitivity once again
            if (splitMessage[0].equalsIgnoreCase("/COUNT")) {
                event.getChannel().sendMessage("The current count is: " + count).queue();
            }

            else {
                //Takes the return value of the counter for use in the /count command
                //Also, is obviously calling the counter to let it work at all
                Counter counter = new Counter();
                count = counter.counterStart(splitMessage[0], event);
            }
        }

    }
}


