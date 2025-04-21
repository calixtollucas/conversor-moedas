package dto;

import java.util.Map;

public class ConversaoExchangeAPI {
    
    private Map<String, Double> conversionRates;
    private String baseCode;

    public String getBaseCode() {
        return baseCode;
    }

    public Double getTax(String currencyCode){
        return conversionRates.get(currencyCode);
    }
    
}
