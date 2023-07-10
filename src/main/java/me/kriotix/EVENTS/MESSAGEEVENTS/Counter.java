/*
 * File: Counter.java
 * Author: Kriotix
 * Last modified: 7/10/2023
 * Purpose: Manages the counting system for the "Count Your Blessings" discord bot
 * */

package me.kriotix.EVENTS.MESSAGEEVENTS;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Counter {
    private static int count = 0;
    public static int counterStart(String message, MessageReceivedEvent event) {

        //Try-catch accounts for if a user enters a word
        try {

            //Turns the String message into an int (so that we can actually count)
            int messageData = Integer.parseInt(message);

            //This is the successful case! It reacts & ups the count
            if (messageData == count + 1) {
                count++;
                event.getMessage().addReaction(Emoji.fromUnicode("✅")).queue();

                //Commenting out just out of preference. I prefer to use the /count command
                //event.getChannel().sendMessage("Count is now " + count).queue();

            //And if the number isn't the next one...
            } else {
                count = 0;
                event.getMessage().addReaction(Emoji.fromUnicode("❌")).queue();

                //I do prefer the message be sent if it's broken
                event.getChannel().sendMessage("Uh-oh! You broke the streak!\n\nCount is now "+ count).queue();
            }

        //And this is our catch, for if it's a word. ParseInt doesn't work if it's a word
        } catch (NumberFormatException nfe) {
                count = 0;
                event.getMessage().addReaction(Emoji.fromUnicode("❌")).queue();
                event.getChannel().sendMessage("A word? What was the plan?!\n\nCount is now "+ count).queue();
        }

        //And whatever happens, count is sent back in the end
        return count;
    }
}



