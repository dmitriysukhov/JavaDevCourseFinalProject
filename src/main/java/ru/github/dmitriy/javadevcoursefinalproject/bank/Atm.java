package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.Getter;
import lombok.extern.java.Log;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.math.BigDecimal;
import java.util.HashSet;

@Getter
@Log
public class Atm {
    private HashSet<TakeMoneyRequest> requests = new HashSet<TakeMoneyRequest>();

    public void takeMoney(Client client, DebitCard card, Money money) throws Exception {
        if (card.isLocked())
            throw new Exception("Карта заблокирована");

        log.info("Номер карты = " + card.getNumber());
        if(!requests.add(new TakeMoneyRequest(card.getNumber(),money))) {
            throw new Exception("Данный запрос не уникален в рамках данного банкомата");
        }

        //для BigDecimal не работает оператор <, поэтому приходится писать этот код
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
