package org.example.bot.callback;


import org.example.bot.enam.StateForBack;
import org.example.bot.util.Buttons;
import org.example.bot.util.UpdateIdProcess;
import org.example.bot.util.UtilLists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class HomeState {
    private static final Logger log = LoggerFactory.getLogger(HomeState.class.getName());


    public static InlineKeyboardMarkup INLINE_MARKUP_START_STATE = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_FIRST_FROM_SUM_TO_VAL))
            .keyboardRow(List.of(Buttons.BTN_SECOND_FROM_VAL_SUM))
            .build();


     public static  void  process(Update update , TelegramLongPollingBot bot){
         UtilLists.stateForBackMap.put(UpdateIdProcess.chatId(update), StateForBack.HOME);
         try {

             bot.execute(SendMessage.builder()
                             .chatId(UpdateIdProcess.chatId(update))
                             .text("welcome to bot ")
                             .replyMarkup(INLINE_MARKUP_START_STATE)
                     .build());
         } catch (TelegramApiException e) {
             log.error(e.getLocalizedMessage());
         }

     }

}
