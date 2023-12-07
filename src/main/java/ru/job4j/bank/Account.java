package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий банковский счет с реквизитами и балансом.
 * Используется в системе банковских переводов.
 *
 * @author VOVA IVANOV
 * @version 1.0
 */
public class Account {
    // Поля класса

    /**
     * Реквизиты банковского счета.
     */
    private String requisite;

    /**
     * Баланс банковского счета.
     */
    private double balance;

    /**
     * Конструктор класса Account.
     *
     * @param requisite Реквизиты банковского счета.
     * @param balance   Начальный баланс банковского счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения реквизитов банковского счета.
     * @return Реквизиты банковского счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для установки реквизитов банковского счета.
     * @param requisite Новые реквизиты банковского счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения баланса банковского счета.
     * @return Баланс банковского счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод для установки баланса банковского счета.
     * @param balance Новый баланс банковского счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals для сравнения объектов типа Account.
     * Два счета считаются равными, если их реквизиты совпадают.
     * @param o Объект для сравнения.
     * @return true, если счета равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode для генерации хеш-кода счета.
     * @return Хеш-код счета на основе его реквизитов.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}