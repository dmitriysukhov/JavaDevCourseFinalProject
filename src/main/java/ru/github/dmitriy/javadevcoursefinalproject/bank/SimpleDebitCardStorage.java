package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.AllArgsConstructor;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
    //класс для реализации простейшего хранилища банковских карт
public class SimpleDebitCardStorage implements DebitCardStorage {
    private List<CardData<DebitCard>> storage;

    public SimpleDebitCardStorage() {
        Money clientCardMoney = new Money(new BigDecimal(2000), Currency.getInstance(Locale.US));
        DebitCard card1 = new DebitCard("12345",clientCardMoney);
        DebitCard card2 = new DebitCard("54321",clientCardMoney);
        CardData<DebitCard> cardData1 = new CardData<>(card1,1111,"", false);
        CardData<DebitCard> cardData2 = new CardData<>(card2,1111,"", false);

        storage = new ArrayList<CardData<DebitCard>>();
        storage.add(cardData1);
        storage.add(cardData2);
    }

    @Override
    public CardData<DebitCard> getDebitCardByNumber(String number) {
        return storage.stream()
            .filter(CardData -> CardData.getCard().getNumber() == number)
            .findFirst()
            .get();
    }
}
