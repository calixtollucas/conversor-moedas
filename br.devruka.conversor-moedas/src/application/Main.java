import java.math.BigDecimal;

import domain.Conversao;
import domain.Currency;
import services.ExchangerAPI;

public class Main {

    private static final String API_KEY = "9b569aeb7a96e467339dcdb9";
    public static void main(String[] args) {

        ExchangerAPI exchanger = new ExchangerAPI(API_KEY);
        Currency currency = new Currency("USD", new BigDecimal(100.0));
        try{
            Conversao conversao = exchanger.fetch(currency, "USD");
            System.out.println(conversao);
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
