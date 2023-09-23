package org.example.bot.message.comment;

import org.example.bot.enam.CommentState;
import org.example.bot.callback.HomeState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Comment {
    public static void commentProcess(Update update, TelegramLongPollingBot bot){
         switch (CommentState.of(update)){
             case STAR -> HomeState.process(update,bot);


         }



    }
}
