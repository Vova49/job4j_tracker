package ru.job4j.checkstyle;

public class Broken {
    private final int sizeOfEmpty = 10;
    private String name;

    public String surname;
    public static String newValue = "";

    Broken() {
    }

    void echo() {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a, int b, int c, int d, int e, int f, int g) {

    }
}