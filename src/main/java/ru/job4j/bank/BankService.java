package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, представляющий банковскую систему для управления пользователями и их счетами.
 * Предоставляет функциональность по добавлению/удалению пользователей, открытию счетов,
 * поиску пользователей и счетов по паспортным данным, а также переводу средств между счетами.
 *
 * @author VOVA IVANOV
 * @version 1.0
 */
public class BankService {

    /**
     * Коллекция для хранения пользователей и их счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления нового пользователя в систему.
     * @param user Добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод для удаления пользователя из системы по паспортным данным.
     * @param passport Паспортные данные пользователя, которого нужно удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод для добавления нового счета пользователю.
     * @param passport Паспортные данные пользователя.
     * @param account Добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод для поиска пользователя по паспортным данным.
     * @param passport Паспортные данные пользователя.
     * @return Объект User, если пользователь найден, иначе null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод для поиска счета по паспортным данным пользователя и реквизитам счета.
     * @param passport Паспортные данные пользователя.
     * @param requisite Реквизиты счета.
     * @return Объект Account, если счет найден, иначе null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перевода средств между счетами.
     * @param srcPassport Паспортные данные отправителя.
     * @param srcRequisite Реквизиты счета отправителя.
     * @param destPassport Паспортные данные получателя.
     * @param destRequisite Реквизиты счета получателя.
     * @param amount Сумма перевода.
     * @return true, если перевод выполнен успешно, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод для получения списка счетов пользователя.
     * @param user Пользователь, чьи счета нужно получить.
     * @return Список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
