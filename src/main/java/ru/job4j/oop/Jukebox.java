package ru.job4j.oop;

public class Jukebox {
    public static void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                break;
            case 2:
                System.out.println("Спокойной ночи");
                break;
            default:
                System.out.println("Песня не найдена");
        }
        String result = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
    }

    public static void main(String[] args) {
        music(1);
        music(2);
        music(3);
    }
}
