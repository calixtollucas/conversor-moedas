package services;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.Conversao;
import domain.Currency;
import dto.ConversaoExchangeAPI;

public class ConversaoMapper {

    private static Gson gsonMapper = null;

    public static Conversao fromJsonToConversao(Currency currency, String targetCurrencyCode, String json){
        //converter json para ConversaoExchangeAPI
        ConversaoExchangeAPI conversaoExchange = getGson().fromJson(json, ConversaoExchangeAPI.class);

        //converter ConversaoExchangeAPI para Conversao
        Conversao conversao = new Conversao(currency, targetCurrencyCode, conversaoExchange);

        //retornar Conversão 
        return conversao;
    } 

    public static Gson getGson(){
        if(ConversaoMapper.gsonMapper == null){
            gsonMapper = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        }
        return gsonMapper;
    }
    
}
