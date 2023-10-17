package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 1);
        Book smartBrain = new Book("Smart Brain", 125);
        Book badCode = new Book("Bad Code", 100);
        Book deliciousFood = new Book("deliciousFood", 236);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = smartBrain;
        books[2] = badCode;
        books[3] = deliciousFood;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + " - " + bo.getNumberOfPages());
        }
        System.out.println("Replace books[0] to books[3].");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bo = books[index];
            System.out.println(bo.getName() + " - " + bo.getNumberOfPages());
        }
        System.out.println("Shown only books.name = Clean Code");
        for (Book book : books) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages());
            }
        }
    }
}
