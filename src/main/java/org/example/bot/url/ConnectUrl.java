package org.example.bot.url;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.bot.model.Money;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ConnectUrl {
//    HttpClient client =  HttpClient.newBuilder()
//            .connectTimeout(Duration.of(3, TimeUnit.SECONDS.toChronoUnit()))
//            .build();
//    HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://cbu.uz/uz/arkhiv-kursov-valyut/json/?Ccy=USD&Ccy=RUB&Ccy=EUR"))
//            .GET()
//            .build();
public static void main(String[] args) {
    System.out.println(getMoneyList());

}
    static     ArrayList<Money> moneyList =new ArrayList<>();
public static ArrayList<Money> getMoneyList(){
    try {
        URL url = new URL(" https://cbu.uz/oz/arkhiv-kursov-valyut/json/?Ccy=USD&Ccy=RUB/");
        URLConnection urlConnection = url.openConnection();
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        moneyList = gson.fromJson(reader,new TypeToken<ArrayList<Money>>(){}.getType());
        return moneyList;


    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}
 



}
