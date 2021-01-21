package ru.github.dmitriy.javadevcoursefinalproject.bank.card;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

//дебетовая пластиковая карта
@Getter
@Setter
@Component("DebitCard")
public class DebitCard extends BankCard {
    private Money money;

    public DebitCard(String number, Money money) {
        super(number);
        this.money = money;
    }
}
