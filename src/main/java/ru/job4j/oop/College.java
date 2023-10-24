package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object object = student;

        System.out.println(freshman.getClass());
        System.out.println(student.getClass());
        System.out.println(object.getClass());
    }
}
