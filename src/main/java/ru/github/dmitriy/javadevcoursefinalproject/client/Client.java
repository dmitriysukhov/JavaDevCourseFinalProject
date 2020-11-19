package ru.github.dmitriy.javadevcoursefinalproject.client;

import ru.github.dmitriy.javadevcoursefinalproject.bank.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;
import ru.github.dmitriy.javadevcoursefinalproject.bank.Atm;


public class Client {
    private DebitCard card;
    private Money cash;
    private String name;

    public Client(DebitCard card, Money cash, String name) {
        this.card = card;
        this.cash = cash;
        this.name = name;
    }

    public void takeMoneyFromDebitCard(Atm atm, Money money) throws Exception {
            atm.takeMoney(this, card, money);
    }

    public DebitCard getCard() {
        return card;
    }

    public void setCard(DebitCard card) {
        this.card = card;
    }

    public Money getCash() {
        return cash;
    }

    public void setCash(Money cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
