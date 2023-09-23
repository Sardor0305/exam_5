package org.example.bot.callback;

import org.example.bot.enam.CalculateState;
import org.example.bot.enam.StateForBack;
import org.example.bot.util.Buttons;
import org.example.bot.util.UpdateIdProcess;
import org.example.bot.util.UtilLists;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;

public class SendAmountOfMoney {
    private static final InlineKeyboardMarkup INLINE_MARKAB_BACK = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_BACK))
            .build();

    public static void processSendMessage(Update update, TelegramLongPollingBot bot){
        UtilLists.stateForBackMap.put(UpdateIdProcess.chatId(update), StateForBack.CALCULATE);
        UtilLists.CALCULATE_STATE_MAP.put(UpdateIdProcess.chatId(update),CalculateState.DEFAULT);
        UtilLists.valueValStateMap.put(UpdateIdProcess.chatId(update),update.getCallbackQuery().getData());
        try {
            bot.execute(EditMessageText.builder()
                            .chatId(UpdateIdProcess.chatId(update))
                            .text("create amount of money:")
                            .replyMarkup(INLINE_MARKAB_BACK)
                            .messageId(UpdateIdProcess.messageId(update))
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
