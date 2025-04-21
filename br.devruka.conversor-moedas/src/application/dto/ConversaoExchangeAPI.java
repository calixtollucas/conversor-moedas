package dto;

import java.util.Map;

import exceptions.ConversaoException;

public class ConversaoExchangeAPI {
    
    private Map<String, Double> conversionRates;
    private String baseCode;

    public String getBaseCode() {
        return baseCode;
    }

    public Double getTax(String currencyCode){

        if(conversionRates == null){
            throw new ConversaoException("Ocorreu um erro ao realizar a conversão, certifique-se de usar os códigos corretos");
        }
        return conversionRates.get(currencyCode);
    }
    
}
