package ru.github.dmitriy.javadevcoursefinalproject.bank;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Log
class AtmTest {
    Money clientCardMoney = new Money(new BigDecimal(2000), Currency.getInstance(Locale.US));
    Money clientCashMoney = new Money(new BigDecimal(1000),Currency.getInstance(Locale.US));
    DebitCard clientDebitCard = new DebitCard(clientCardMoney, 1234,false,"12345");
    DebitCard clientDebitCard2 = new DebitCard(clientCardMoney, 4321,false,"54321");

    Client newClient = new Client(clientDebitCard, clientCashMoney, "Ivan Ivanov");
    Client newClient2 = new Client(clientDebitCard2, clientCashMoney, "Sergey Ivanov");

    Money requestMoney = new Money(new BigDecimal(100),Currency.getInstance(Locale.US));
    Atm atm = new Atm();

    void tryTakeMoney(Client client, Money money) {
        try {
            atm.takeMoney(client, client.getCard(), money);
        }
        catch (Exception ex) {
            log.severe(ex.getMessage());
        }
    }

    @Test
    void takeMoneyCheckUniqueRequest() {
        log.info("Test launches");
        tryTakeMoney(newClient, requestMoney);
        tryTakeMoney(newClient, requestMoney);
        tryTakeMoney(newClient2, requestMoney);
        assertEquals(2, atm.getRequests().size());
    }

}