package org.example.bot;


import org.example.bot.callback.CallBackHome;
import org.example.bot.callback.HomeState;
import org.example.bot.message.comment.Comment;
import org.example.bot.callback.SendMoney;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MoneyBot extends TelegramLongPollingBot {
    public MoneyBot() {
        super("6303622533:AAHsVQPyvhaxWJzaCVNcmOl0Z-moPp14wnA");
    }

    Logger log = LoggerFactory.getLogger(HomeState.class.getName());

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            if(update.getMessage().isCommand()){
                Comment.commentProcess(update,this);
            }
            else if(update.getMessage().hasText()){
                SendMoney.sendMoneyOfAmount(update,this);
            }
        }
        else if(update.hasCallbackQuery()){
            CallBackHome.process(update,this);
        }



    }

    @Override
    public String getBotUsername() {
        return "@pulkursibot";
    }
}
