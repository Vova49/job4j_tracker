package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс, представляющий пользователя системы банковских переводов.
 * Содержит информацию о паспортных данных и имени пользователя.
 *
 * @author VOVA IVANOV
 * @version 1.0
 */
public class User {

    /**
     * Паспортные данные пользователя.
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор класса User.
     *
     * @param passport Паспортные данные пользователя.
     * @param username Имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для получения паспортных данных пользователя.
     * @return Паспортные данные пользователя.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для установки паспортных данных пользователя.
     * @param passport Новые паспортные данные пользователя.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для получения имени пользователя.
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для установки имени пользователя.
     * @param username Новое имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals для сравнения объектов типа User.
     * Два пользователя считаются равными, если их паспортные данные совпадают.
     * @param o Объект для сравнения.
     * @return true, если пользователи равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode для генерации хеш-кода пользователя.
     * @return Хеш-код пользователя на основе его паспортных данных.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}