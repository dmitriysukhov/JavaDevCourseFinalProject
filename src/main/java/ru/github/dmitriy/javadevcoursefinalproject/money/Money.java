package ru.github.dmitriy.javadevcoursefinalproject.money;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Money extends Object {
    private BigDecimal sum;
    private Currency currency;
}
