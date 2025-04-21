package domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import dto.ConversaoExchangeAPI;

public class Conversao {
    
    private Currency currency;
    private Currency targetCurrency;
    private double tax;

    public Conversao(Currency currency, String targetCurrencyCode, ConversaoExchangeAPI conversaoExchangeAPI){
        this.currency = currency;
        this.tax = conversaoExchangeAPI.getTax(targetCurrencyCode);
        this.targetCurrency = new Currency(targetCurrencyCode, currency.getValue().multiply(new BigDecimal(tax)).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Override
    public String toString() {
        return "Conversao [currency=" + currency + "\n targetCurrency=" + targetCurrency + "\n tax=" + tax + "]";
    }
    
}
