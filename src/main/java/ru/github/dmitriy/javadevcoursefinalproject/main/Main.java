package ru.github.dmitriy.javadevcoursefinalproject.main;

import ru.github.dmitriy.javadevcoursefinalproject.bank.Atm;
import ru.github.dmitriy.javadevcoursefinalproject.bank.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Money clientCardMoney = new Money(new BigDecimal(2000),Currency.getInstance(Locale.US));
        Money clientCashMoney = new Money(new BigDecimal(1000),Currency.getInstance(Locale.US));
        DebitCard clientDebitCard = new DebitCard(clientCardMoney, 1234,false,"12345");
        Client newClient = new Client(clientDebitCard, clientCashMoney, "Ivan Ivanov");

        Atm atm = new Atm();
        Money requestMoney = new Money(new BigDecimal(100),Currency.getInstance(Locale.US));
        try {
            atm.takeMoney(newClient, newClient.getCard(), requestMoney);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
