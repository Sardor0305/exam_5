package org.example.bot.callback;



import org.example.bot.enam.CallDate;
import org.example.bot.enam.StateForBack;
import org.example.bot.util.Buttons;
import org.example.bot.util.UpdateIdProcess;
import org.example.bot.util.UtilLists;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;


public class ProcessState {
    public static InlineKeyboardMarkup INLINE_MARKAB_CHOICE_MONEY = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_USD))
            .keyboardRow(List.of(Buttons.BTN_EUR))
            .keyboardRow(List.of(Buttons.BTN_RUB))
            .keyboardRow(List.of(Buttons.BTN_BACK))
            .build();

     public static void processChoiceMoney(Update update , TelegramLongPollingBot  bot){
         UtilLists.stateForBackMap.put(UpdateIdProcess.chatId(update), StateForBack.CHOICE_VAL);
         UtilLists.valueStateMap.put(UpdateIdProcess.chatId(update),update.getCallbackQuery().getData());
         try {
             bot.execute(EditMessageText.builder()
                             .text("choice money")
                             .chatId(UpdateIdProcess.chatId(update))
                             .messageId(UpdateIdProcess.messageId(update))
                             .replyMarkup(INLINE_MARKAB_CHOICE_MONEY)
                     .build());
         } catch (TelegramApiException e) {
             throw new RuntimeException(e);
         }
     }

}


