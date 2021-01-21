package ru.github.dmitriy.javadevcoursefinalproject.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.github.dmitriy.javadevcoursefinalproject.bank.atm.Atm;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Autowired
    Environment env;

    @Bean
    public Atm MyAtm() {
        return new Atm();
    }

    @Bean
    public DebitCard ClientDebitCard()
    {
        Money clientCardMoney = new Money(new BigDecimal(env.getProperty("money.balance")), Currency.getInstance(Locale.US));
        return new DebitCard(env.getProperty("debitCard.number"), clientCardMoney);
    }

    @Bean
    public Client MyClient() {
        return new Client(ClientDebitCard(),env.getProperty("client.name"));
    }
}
