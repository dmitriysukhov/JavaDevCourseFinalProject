package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import lombok.EqualsAndHashCode;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TakeMoneyRequest {
    private String cardNumber;
    private Money money;
}
