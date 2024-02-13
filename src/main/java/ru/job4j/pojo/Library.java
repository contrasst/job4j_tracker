package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Garry Potter", 250);
        Book book2 = new Book("Clean Code", 180);
        Book book3 = new Book("History of world", 280);
        Book book4 = new Book("Effective Java", 220);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Replace 0 book to 3 book");
        books[0] = book4;
        books[3] = book1;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Clean Code books");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
 }
