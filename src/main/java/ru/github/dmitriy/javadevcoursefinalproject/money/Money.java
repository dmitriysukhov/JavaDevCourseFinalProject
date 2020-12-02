package ru.github.dmitriy.javadevcoursefinalproject.money;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private BigDecimal sum;
    private Currency currency;

    public Money(BigDecimal sum, Currency currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
