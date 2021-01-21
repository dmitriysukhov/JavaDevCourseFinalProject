package ru.github.dmitriy.javadevcoursefinalproject.bank.atm;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.CardData;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.storage.DebitCardStorage;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.storage.SimpleDebitCardStorage;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataException;
import ru.github.dmitriy.javadevcoursefinalproject.bank.exception.CardDataFatalException;
import ru.github.dmitriy.javadevcoursefinalproject.client.Client;
import ru.github.dmitriy.javadevcoursefinalproject.bank.card.DebitCard;
import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

import java.util.Optional;
import java.util.function.BiPredicate;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@Getter
@Log
@Component("Atm")
public class Atm {
    private Set<TakeMoneyRequest> requests = new HashSet<>();
    private DebitCardStorage cardStorage = new SimpleDebitCardStorage();

    public void takeMoney(Client client, DebitCard card, Money money, int pin) throws CardDataException, CardDataFatalException {
        //получение данных о карте с сервера
        Predicate<CardData<DebitCard>> predicate = cardData -> cardData.getCard().getNumber().equals(card.getNumber());
        Optional<CardData<DebitCard>> optionalCardData = cardStorage.getDebitCardByPredicate(predicate);

        if (!optionalCardData.isPresent())
            throw new CardDataFatalException("Информация по данной карте отсутствует");
        else if (optionalCardData.get().isLocked()) {
            throw new CardDataFatalException("Карта заблокирована");
        }
        else if(optionalCardData.get().getPin() != pin){
            throw new CardDataException("Неверный Pin-код");
        }

        log.info("Номер карты = " + card.getNumber());
        if(!requests.add(new TakeMoneyRequest(card.getNumber(),money))) {
            throw new CardDataException("Данный запрос не уникален в рамках данного банкомата");
        }

        //для BigDecimal не работает оператор <, поэтому приходится писать этот код
        BiPredicate<BigDecimal,BigDecimal> isLess = (BigDecimal a, BigDecimal b) -> a.compareTo(b) > 0;
        if(isLess.test(money.getSum(),card.getMoney().getSum()))
            throw new CardDataException("На карте недостаточно денег");

        //кусок кода по вычитанию денег с банковской картиы и добавлению их к количеству наличных у клиента
        BigDecimal currentCardSum = card.getMoney().getSum();
        BigDecimal resultCardSum =  currentCardSum.subtract(money.getSum());
        client.getCard().getMoney().setSum(resultCardSum);
    }
}
