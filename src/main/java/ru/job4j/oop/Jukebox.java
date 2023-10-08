package ru.job4j.oop;

public class Jukebox {
    public static void music(int position) {
        String result = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        music(1);
        music(2);
        music(3);
    }
}
