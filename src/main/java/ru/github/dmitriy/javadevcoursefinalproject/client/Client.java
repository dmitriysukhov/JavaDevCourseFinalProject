package ru.github.dmitriy.javadevcoursefinalproject.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.github.dmitriy.javadevcoursefinalproject.bank.atm.Atm;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataException;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataFatalException;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
@Getter
@AllArgsConstructor
@Component("Ivan Ivanov")
public class Client {
    private DebitCard card;
    private String name;

    public void takeMoneyFromDebitCard(Atm atm, Money money, @Min(0000) @Max(9999) int pin) throws CardDataFatalException, CardDataException {
            atm.takeMoney(this, card, money, pin);
    }
}
