package com.company;

public class Book {
    private String author;
    private String title;
    private int year;
    private String genre;

    public Book(String author, String title, int year, String genre) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return author + ", " + year + ", " + title;
    }

//    @Override
//    public int compareTo(Book other) {
//        return this.title.compareTo(other.title);
//    }
}
