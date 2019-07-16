package com.homework;

import java.text.DecimalFormat;

public class BankAccount {

    private String name;
    private double money;
    private static double bankProfit = 0.0;

    public BankAccount(String name, double money) {
        this.name = name;
        this.money = money;
    }

    private static double bankProfit(double money, double percent) {
        double tmp = (money / 100) * percent;
        bankProfit += tmp;
        return tmp;
    }

    private static String myDecimalFormat(double money) {
        DecimalFormat myFormatter = new DecimalFormat("###.##\u20B4");
        return myFormatter.format(money);
    }

    // 0.5% commission
    public void add(double moneyInputValue) {
        money = moneyInputValue - bankProfit(moneyInputValue, 0.5);
    }

    // 1% commission
    public void transfer(BankAccount otherPerson, double salary) {
        if (salary > money) {
            throw new IllegalArgumentException("На счету не достаточно средств для выплаты зарплаты такого размера!");
        }
        otherPerson.money = salary - bankProfit(salary, 1);
        money -= otherPerson.money;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "Владелец счета = '" + name + '\'' +
                ", денег на счету = " + myDecimalFormat(money) +
                '}';
    }

    public static void toStringBankProfit() {
        System.out.println("Банк заработал " + myDecimalFormat(bankProfit));
    }
}