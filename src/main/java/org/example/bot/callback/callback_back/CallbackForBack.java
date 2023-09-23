package org.example.bot.callback.callback_back;

import org.example.bot.callback.HomeState;
import org.example.bot.callback.ProcessState;
import org.example.bot.util.UpdateIdProcess;
import org.example.bot.util.UtilLists;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CallbackForBack {
    public static void backProcess(Update update, TelegramLongPollingBot bot){
        switch (UtilLists.stateForBackMap.get(UpdateIdProcess.chatId(update))){
            case CHOICE_VAL -> HomeState.process(update,bot);
            case CALCULATE -> ProcessState.processChoiceMoney(update,bot);

        }
    }
    public static void BackForLastState(Update update,TelegramLongPollingBot bot){
        switch (UtilLists.stateForBackMap.get(UpdateIdProcess.chatId(update))){
            case SEND_AMOUNT -> HomeState.process(update,bot);
        }
    }
}
