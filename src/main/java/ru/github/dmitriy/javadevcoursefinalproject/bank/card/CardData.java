package ru.github.dmitriy.javadevcoursefinalproject.bank.card;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//класс для агрегации данных по банковской карте
@Setter
@Getter
@AllArgsConstructor
public class CardData<T extends BankCard> {
    private T card;
    private int pin;
    private String expiredDate;
    private boolean isLocked;
}
