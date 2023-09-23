package org.example.bot.callback;

import org.example.bot.callback.callback_back.CallbackForBack;
import org.example.bot.enam.CallDate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CallBackHome {
    public static void process(Update update , TelegramLongPollingBot bot) {
        switch (CallDate.of(update.getCallbackQuery().getData())) {
            case CALLBACK_FROM_SUM_T0_VAL, CALLBACK_FROM_VAL_TO_SUM -> ProcessState.processChoiceMoney(update, bot);
            case CALLBACK_EUR, CALLBACK_RUB, CALLBACK_USD -> SendAmountOfMoney.processSendMessage(update, bot);
            case CALLBACK_HOME -> CallbackForBack.BackForLastState(update, bot);
            case CALLBACK_BACK -> CallbackForBack.backProcess(update, bot);

        }


    }

}
