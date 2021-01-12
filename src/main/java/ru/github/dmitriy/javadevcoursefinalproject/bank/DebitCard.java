package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

//дебетовая пластиковая карта
@Getter
@Setter
public class DebitCard extends BankCard {
    private Money money;

    //TODO не получилось убрать в Lombok
    public DebitCard(String number, Money money) {
        super(number);
        this.money = money;
    }
}
