package org.example.bot.enam;

import org.example.bot.util.UpdateIdProcess;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum CommentState{
    STAR("/start"),
    HELP("/help"),

    ABOUT("/about");
private static final Map<String,CommentState>map = new HashMap<>();
static {
    for (CommentState s: CommentState.values()) {
        map.put(s.value,s);
    }
}

    private final String value;
    CommentState(String value){
        this.value = value;
    }
    public static CommentState of(Update update){
        return map.get(update.getMessage().getText());
    }
}
