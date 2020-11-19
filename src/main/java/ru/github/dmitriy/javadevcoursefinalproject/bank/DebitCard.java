package ru.github.dmitriy.javadevcoursefinalproject.bank;

import ru.github.dmitriy.javadevcoursefinalproject.money.Money;

public class DebitCard {
    private Money money;
    private int pin;
    private boolean isLocked;

    public DebitCard(Money money, int pin, boolean isLocked) {
        this.money = money;
        this.pin = pin;
        this.isLocked = isLocked;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
