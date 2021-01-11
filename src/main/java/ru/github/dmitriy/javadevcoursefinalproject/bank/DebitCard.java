package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

@Getter
@Setter
@AllArgsConstructor
public class DebitCard {
    private Money money;
    private int pin;
    private boolean isLocked;
    private String number;
}
