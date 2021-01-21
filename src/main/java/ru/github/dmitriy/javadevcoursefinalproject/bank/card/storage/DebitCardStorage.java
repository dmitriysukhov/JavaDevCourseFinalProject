package ru.github.dmitriy.javadevcoursefinalproject.bank.card.storage;

import ru.github.dmitriy.javadevcoursefinalproject.bank.card.CardData;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;

import java.util.Optional;
import java.util.function.Predicate;

public interface DebitCardStorage {
    Optional<CardData<DebitCard>> getDebitCardByPredicate(Predicate<CardData> predicate);
}
