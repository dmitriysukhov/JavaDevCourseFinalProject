package ru.github.dmitriy.javadevcoursefinalproject.bank;

public interface DebitCardStorage {
    CardData<DebitCard> getDebitCardByNumber(String number);
}
