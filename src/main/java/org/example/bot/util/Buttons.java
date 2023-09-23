package org.example.bot.util;


import org.example.bot.enam.CallDate;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class Buttons {
    /**
     * first button
     */

    public static InlineKeyboardButton BTN_FIRST_FROM_SUM_TO_VAL = InlineKeyboardButton.builder()
            .text("1 sum -> val")
            .callbackData(CallDate.CALLBACK_FROM_SUM_T0_VAL.getValue())
        .build();
    public static InlineKeyboardButton BTN_SECOND_FROM_VAL_SUM = InlineKeyboardButton.builder()
            .text("2 val -> sum")
            .callbackData(CallDate.CALLBACK_FROM_VAL_TO_SUM.getValue())
            .build();
    /**
     * choice money
     */
    public static InlineKeyboardButton BTN_USD = InlineKeyboardButton.builder()
            .text("USD")
            .callbackData(CallDate.CALLBACK_USD.getValue())
            .build();
    public static InlineKeyboardButton BTN_EUR = InlineKeyboardButton.builder()
            .text("EUR")
            .callbackData(CallDate.CALLBACK_EUR.getValue())
            .build();
    public static InlineKeyboardButton BTN_RUB = InlineKeyboardButton.builder()
            .text("RUB")
            .callbackData(CallDate.CALLBACK_RUB.getValue())
            .build();
    public static InlineKeyboardButton BTN_BACK = InlineKeyboardButton.builder()
            .text("BACK")
            .callbackData(CallDate.CALLBACK_BACK.getValue())
            .build();
    public static InlineKeyboardButton BTN_HOME = InlineKeyboardButton.builder()
            .text("HOME")
            .callbackData(CallDate.CALLBACK_RUB.getValue())
            .build();

}
