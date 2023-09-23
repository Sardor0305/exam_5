package org.example.bot.enam;

import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CallDate {
    CALLBACK_FROM_SUM_T0_VAL("first"),
    CALLBACK_FROM_VAL_TO_SUM("second"),

    CALLBACK_USD("usd"),
    CALLBACK_EUR("eur"),
    CALLBACK_RUB("rub"),
    CALLBACK_BACK("back"),
    CALLBACK_HOME("home");
    private static final Map<String,CallDate> map = new HashMap<>();
    static {
        for (CallDate s: CallDate.values()) {
            map.put(s.value,s);
        }
    }

    private final String value;

    CallDate(String value){
        this.value = value;
    }
    public static CallDate of(String s){
        return map.get(s);
    }

}
