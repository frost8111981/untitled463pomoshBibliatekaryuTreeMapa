package com.company;

import java.util.TreeMap;
import java.util.TreeSet;

public class BookCatalog {
    private TreeMap<String, TreeSet<Book>> genres;

    public void setGenres(TreeMap<String, TreeSet<Book>> genres) {
        this.genres = genres;
    }

    public BookCatalog() {
        this.genres = new TreeMap<>();
    }

    public void addBook(Book book) {
        String genre = book.getGenre();
        TreeSet<Book> books = genres.getOrDefault(genre, new TreeSet<>(new ComparatorBook()));
        books.add(book);
        genres.put(genre, books);
    }

    public void printGenres() {
        // Выводим все доступные жанры в алфавитном порядке
        for (String genre : genres.keySet()) {
            System.out.println(genre);
        }
    }

    public void printGenre(String genre) {
        // Выводим все книги указанного жанра в алфавитном порядке
        TreeSet<Book> books = genres.get(genre);
        if (books != null) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("Жанр не найден");
        }
    }

    public void printGenres(boolean withBooks) {
        // Выводим все жанры в алфавитном порядке
        for (String genre : genres.keySet()) {
            System.out.println(genre);
            if (withBooks) {
                // Если нужно вывести книги, выводим их внутри жанра
                TreeSet<Book> books = genres.get(genre);
                for (Book book : books) {
                    System.out.println("\t" + book);
                }
            }
        }
    }

    public TreeMap<String, TreeSet<Book>> getGenres() {
        return genres;
    }


}
