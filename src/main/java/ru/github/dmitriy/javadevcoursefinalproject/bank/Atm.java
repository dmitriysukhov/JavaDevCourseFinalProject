package ru.github.dmitriy.javadevcoursefinalproject.bank;

import lombok.Getter;
import lombok.extern.java.Log;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;
import java.util.function.BiPredicate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Log
public class Atm {
    private Set<TakeMoneyRequest> requests = new HashSet<TakeMoneyRequest>();
    private DebitCardStorage cardStorage = new SimpleDebitCardStorage();

    public void takeMoney(Client client, DebitCard card, Money money, int pin) throws Exception {
        if (cardStorage.getDebitCardByNumber(card.getNumber()).isLocked())
            throw new Exception("Карта заблокирована");

        log.info("Номер карты = " + card.getNumber());
        if(!requests.add(new TakeMoneyRequest(card.getNumber(),money))) {
            throw new Exception("Данный запрос не уникален в рамках данного банкомата");
        }

        //для BigDecimal не работает оператор <, поэтому приходится писать этот код
        BiPredicate<BigDecimal,BigDecimal> isLess = (BigDecimal a, BigDecimal b) ->
                                                                { return a.compareTo(b) == 1; };
        if(isLess.test(money.getSum(),card.getMoney().getSum()))
            throw new Exception("На карте недостаточно денег");

        //кусок кода по вычитанию денег с банковской картиы и добавлению их к количеству наличных у клиента
        BigDecimal currentCardSum = card.getMoney().getSum();
        BigDecimal currentCashSum = client.getCash().getSum();
        BigDecimal resultCardSum =  currentCardSum.subtract(money.getSum());
        BigDecimal resultCashSum = currentCashSum.add(money.getSum());
        client.getCash().setSum(resultCashSum);
        client.getCard().getMoney().setSum(resultCardSum);
    }
}
