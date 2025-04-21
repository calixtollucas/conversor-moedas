package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import dto.ConversaoExchangeAPI;
import exceptions.ConversaoException;

public class Conversao {
    
    private Currency currency;
    private Currency targetCurrency;
    private double tax;
    private ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

    public Conversao(Currency currency, String targetCurrencyCode, ConversaoExchangeAPI conversaoExchangeAPI){
        this.currency = currency;

        Double tax = conversaoExchangeAPI.getTax(targetCurrencyCode);

        if( tax == null){
            throw new ConversaoException("Ocorreu um erro ao realizar a conversão, certifique-se de usar os códigos corretos");
        } else {
            this.tax = tax;
        }
        this.targetCurrency = new Currency(targetCurrencyCode, currency.getValue().multiply(new BigDecimal(tax)).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Override
    public String toString() {
        return "Conversao [currency=" + currency + "\n targetCurrency=" + targetCurrency + "\n tax=" + tax + "]";
    }


    public Currency getCurrency() {
        return currency;
    }


    public Currency getTargetCurrency() {
        return targetCurrency;
    }


    public double getTax() {
        return tax;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
    
}
