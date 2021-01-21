package ru.github.dmitriy.javadevcoursefinalproject.main;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.github.dmitriy.javadevcoursefinalproject.bank.atm.Atm;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataException;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataFatalException;
import ru.github.dmitriy.javadevcoursefinalproject.beans.SpringConfig;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Log
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Atm atm = context.getBean("MyAtm", Atm.class);
        Client newClient = context.getBean("MyClient", Client.class);

        Money requestMoney = new Money(new BigDecimal(100),Currency.getInstance(Locale.US));
        try {
            atm.takeMoney(newClient, newClient.getCard(), requestMoney, 1111);
        }
        catch (CardDataFatalException ex) {
            log.severe(ex.getMessage());
            System.exit(-1);
        }
        catch (CardDataException ex) {
            log.info(ex.getMessage());
        }
    }
}
