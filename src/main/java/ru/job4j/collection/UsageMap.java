package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("vovafokyz@gmail.com", "Ivanov Volodymyr Olegovich");
        map.put("stepankorobko@gmail.com", "Stepan Korobko Petrovich");
        for (String key : map.keySet()) {
            System.out.println("Email: " + key + ", ФИО: " + map.get(key));
        }
    }
}
