package domain;

import java.math.BigDecimal;

public class Currency{
    String code;
    BigDecimal value;
    
    public Currency(String code, BigDecimal value) {
        this.code = code;
        this.value = value;
    }

    public Currency(String code) {
        this.code = code;
        this.value = null;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Currency [code=" + code + ", value=" + value + "]";
    }

    

    
}