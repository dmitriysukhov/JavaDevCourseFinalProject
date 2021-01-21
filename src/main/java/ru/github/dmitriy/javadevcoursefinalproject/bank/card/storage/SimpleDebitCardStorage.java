package ru.github.dmitriy.javadevcoursefinalproject.bank.card.storage;

import ru.github.dmitriy.javadevcoursefinalproject.bank.card.CardData;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

//класс для реализации простейшего хранилища банковских карт
public class SimpleDebitCardStorage implements DebitCardStorage {
    private List<CardData<DebitCard>> storage;

    public SimpleDebitCardStorage() {
        Money clientCardMoney = new Money(new BigDecimal(2000), Currency.getInstance(Locale.US));
        DebitCard card1 = new DebitCard("12345",clientCardMoney);
        DebitCard card2 = new DebitCard("54321",clientCardMoney);
        CardData<DebitCard> cardData1 = new CardData<>(card1,1111,"", false);
        CardData<DebitCard> cardData2 = new CardData<>(card2,1111,"", false);

        storage = new ArrayList<>();
        storage.add(cardData1);
        storage.add(cardData2);
    }

    public Optional<CardData<DebitCard>> getDebitCardByPredicate(Predicate<CardData<DebitCard>> predicate) {
        return storage.stream()
            .filter(predicate)
            .findFirst();
    }
}
