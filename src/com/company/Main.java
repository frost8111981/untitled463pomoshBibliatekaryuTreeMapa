package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект типа Scanner для чтения ввода из консоли
        Scanner scanner = new Scanner(System.in);
        // Создаем объект каталога книг
        BookCatalog catalog = new BookCatalog();

        while (scanner.hasNextLine()) {
            System.out.println("Введите данные по книге:");
            System.out.print("Название: ");
            String title = scanner.nextLine();

            System.out.print("Автор: ");
            String author = scanner.nextLine();

            System.out.print("Год издания: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Жанр: ");
            String genre = scanner.nextLine();

            // Создаем объект книги
            Book book = new Book(author, title, year, genre);
            // Добавляем книгу в каталог
            catalog.addBook(book);

            System.out.println("Доступные жанры (выберите для вывода):");
            System.out.println("0. Вывести все жанры");

            // Выводим номера и названия жанров для выбора
            int i = 1;
            for (String g : catalog.getGenres().keySet()) {
                System.out.println(i + ". " + g);
                i++;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                // Выводим все доступные жанры
                catalog.printGenres();
            } else if (choice > 0 && choice <= catalog.getGenres().size()) {
                // Выводим книги выбранного жанра
                String selectedGenre = (String) catalog.getGenres().keySet().toArray()[choice - 1];
                catalog.printGenre(selectedGenre);
            } else {
                System.out.println("Неверный выбор");
            }

            System.out.println();
        }
    }
}
