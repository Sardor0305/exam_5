package org.example.bot.callback;

import org.example.bot.enam.CalculateState;
import org.example.bot.enam.CallDate;
import org.example.bot.enam.StateForBack;
import org.example.bot.message.comment.CalculateMoney;
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
import java.util.regex.Pattern;

public class SendMoney {
    private static final InlineKeyboardMarkup INLINE_MARKAB_HOME = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Buttons.BTN_HOME))
            .build();
    private static final Pattern PATTERN = Pattern.compile("[0-9]+");

    public static void sendMoneyOfAmount(Update update, TelegramLongPollingBot bot){
        UtilLists.stateForBackMap.put(UpdateIdProcess.chatId(update), StateForBack.SEND_AMOUNT);
        if(UtilLists.CALCULATE_STATE_MAP.get(UpdateIdProcess.chatId(update)).equals(CalculateState.DEFAULT)) {

            if (PATTERN.matcher(update.getMessage().getText()).matches()) {


                if (UtilLists.valueStateMap.get(UpdateIdProcess.chatId(update)).
                        equals(CallDate.CALLBACK_FROM_SUM_T0_VAL.getValue())) {
                    Double senMooneyFromUser = Double.valueOf(update.getMessage().getText());
                    Double valyuta = CalculateMoney.checkMoney(update);
                    System.out.println(valyuta);
                    try {
                        bot.execute(SendMessage.builder()
                                .text((senMooneyFromUser * valyuta) + "SUM")
                                .chatId(UpdateIdProcess.chatId(update))
                                .replyMarkup(INLINE_MARKAB_HOME)
//                                .messageId(UpdateIdProcess.messageId(update))
                                .build());
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (UtilLists.valueStateMap.get(UpdateIdProcess.chatId(update)).
                        equals(CallDate.CALLBACK_FROM_VAL_TO_SUM.getValue())) {
                    Double senMooneyFromUser = Double.valueOf(update.getMessage().getText());
                    Double valyuta = CalculateMoney.checkMoney(update);
                    System.out.println(valyuta);
                    try {
                        bot.execute(SendMessage.builder()
                                .text((senMooneyFromUser / valyuta) + CalculateMoney.nameVal())
                                .chatId(UpdateIdProcess.chatId(update))
                                .replyMarkup(INLINE_MARKAB_HOME)
//                                .messageId(UpdateIdProcess.messageId(update))
                                .build());
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else {

                try {
                    bot.execute(SendMessage.builder()
                                    .text("incorrect please create number")
//                                    .messageId(UpdateIdProcess.messageId(update))
                                    .chatId(UpdateIdProcess.chatId(update))
                            .build());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
