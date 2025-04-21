package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import domain.Conversao;
import domain.Currency;

public class ExchangerAPI {

    private String key;
    private String apiUrl = "https://v6.exchangerate-api.com/v6/";
    private HttpClient client = null;

    public ExchangerAPI(String key) {
        this.key = key;
    }
    
    public Conversao fetch(Currency currency, String targetCurrencyCode) throws IOException, InterruptedException{
        //consulta a api
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl+key+"/latest/"+currency.getCode()))
            .build();
        
        HttpResponse<String> response = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        //converte json em conversao
        Conversao conversao = ConversaoMapper.fromJsonToConversao(currency, targetCurrencyCode, response.body());
        //loga conversão
        ConversaoLogger.log(conversao);
        //retorna conversao
        return conversao;
    }

    private HttpClient getClient(){
        if(this.client == null){
            this.client = HttpClient.newHttpClient();
        }

        return client;
    }
}
