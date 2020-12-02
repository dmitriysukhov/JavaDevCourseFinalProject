package ru.github.dmitriy.javadevcoursefinalproject.bank;

import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;

public class Atm {
    public void takeMoney(Client client, DebitCard card, Money money) throws Exception {
        if (card.isLocked())
            throw new Exception("Карта заблокирована");
        int comparisonResult = money.getSum().compareTo(card.getMoney().getSum());
        if(comparisonResult != -1)
            throw new Exception("На карте недостаточно денег");
        BigDecimal currentCardSum = card.getMoney().getSum();
        BigDecimal currentCashSum = client.getCash().getSum();
        BigDecimal resultCardSum =  currentCardSum.subtract(money.getSum());
        BigDecimal resultCashSum = currentCashSum.add(money.getSum());
        client.getCash().setSum(resultCashSum);
        client.getCard().getMoney().setSum(resultCardSum);
    }
}
