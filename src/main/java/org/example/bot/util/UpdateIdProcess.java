package org.example.bot.util;

import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateIdProcess {
    public static Long chatId(Update update){
        if(update.hasMessage()){
            return update.getMessage().getChatId();
        }
        else if(update.hasCallbackQuery()){
            return update.getCallbackQuery().getMessage().getChatId();
        }
        throw  new RuntimeException("not found chatId");
    }

public static Integer messageId(Update update){
        if(update.hasMessage()){
            return update.getMessage().getMessageId();
        }
        else if(update.hasCallbackQuery()){
            return update.getCallbackQuery().getMessage().getMessageId();
        }
        throw new RuntimeException("not found message id");
}
}
