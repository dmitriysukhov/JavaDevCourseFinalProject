package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.AllArgsConstructor;

import java.util.List;

public class SimpleDebitCardStorage {
    //класс для реализации простейшего хранилища банковских карт
    @AllArgsConstructor
    public class SimpleCardStorage implements DebitCardStorage {
        private List<CardData<DebitCard>> storage;

        public CardData<DebitCard> getDebitCardByNumber(String cardNumber) {
            return storage.stream()
                    .filter(CardData -> CardData.getCard().getNumber() == cardNumber)
                    .findFirst()
                    .get();
        }
    }
}
