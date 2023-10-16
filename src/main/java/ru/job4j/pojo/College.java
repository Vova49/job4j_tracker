package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Volodymyr");
        student.setGroup("First");
        student.setDateOfReceipt("14.06.2022");
        System.out.println("Name:" + student.getFullName() + ", group:" + student.getGroup() + ", DateOfReceipt:" + student.getDateOfReceipt());
    }
}
