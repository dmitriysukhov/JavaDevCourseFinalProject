package ru.github.dmitriy.javadevcoursefinalproject.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.github.dmitriy.javadevcoursefinalproject.bank.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;
import ru.github.dmitriy.javadevcoursefinalproject.bank.Atm;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
@AllArgsConstructor
public class Client {
    private DebitCard card;
    private Money cash;
    private String name;

    public void takeMoneyFromDebitCard(Atm atm, Money money, @Min(0000) @Max(9999) int pin) throws Exception {
            atm.takeMoney(this, card, money, pin);
    }
}
