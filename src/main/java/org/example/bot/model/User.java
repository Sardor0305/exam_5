package org.example.bot.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.bot.enam.StateForBack;
import org.example.bot.enam.StateForHome;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {

    private Long chatId;
    private StateForHome state;

}
