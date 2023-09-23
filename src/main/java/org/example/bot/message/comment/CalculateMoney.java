package org.example.bot.message.comment;

import org.example.bot.enam.CallDate;
import org.example.bot.model.Money;
import org.example.bot.url.ConnectUrl;
import org.example.bot.util.UpdateIdProcess;
import org.example.bot.util.UtilLists;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;

public class CalculateMoney {
 private static final  ArrayList<Money> moneyList = ConnectUrl.getMoneyList();
 private static int emp = 0;
    public static Double checkMoney(Update update){

        for (int i = 0; i < moneyList.size(); i++) {
            if(UtilLists.valueValStateMap.get(UpdateIdProcess.chatId(update)).
                    equals(moneyList.get(i).getCcy().toLowerCase())){
                emp = i;
                    return  moneyList.get(i).getRate();
            }
        }
        return 0.0;
    }
    public static String nameVal(){
        return moneyList.get(emp).getCcy();
    }



}
