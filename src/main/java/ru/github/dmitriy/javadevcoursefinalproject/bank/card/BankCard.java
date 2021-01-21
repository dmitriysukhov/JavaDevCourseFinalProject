package ru.github.dmitriy.javadevcoursefinalproject.bank.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//класс для агрегации клиентских данных по пластиковой банковской карте
@Getter
@Setter
@AllArgsConstructor
public abstract class BankCard {
    private String number;
}
