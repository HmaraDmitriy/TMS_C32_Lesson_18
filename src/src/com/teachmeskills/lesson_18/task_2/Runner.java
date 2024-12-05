package com.teachmeskills.lesson_18.task_2;


/*Задача 2
Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
С помощью Stream'ов:
        - Выбрать все имена, начинающиеся на любую букву, введенную с консоли (вне зависимости от верхнего/нижнего регистра букв)
    	- Отсортировать и вернуть первый элемент коллекции*/


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Dmitriy");
        list.add("Ilya");
        list.add("Flame");
        list.add("Igor");
        list.add("Marina");
        list.add("Daniil");
        list.add("Sultan");

        System.out.println("List Student" + list);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter to filter names:");
        String input = scanner.nextLine();

        if (input.isEmpty() || input.length() > 1) {
            System.out.println("Please enter only a single letter!");
        }

        char filterLetter = input.toLowerCase().charAt(0);

        List<String> filteredNames = list.stream()
                .filter(name -> name.toLowerCase().startsWith(String.valueOf(filterLetter)))
                .collect(Collectors.toList());

        System.out.println("Filtered Names: " + filteredNames);

        Optional<String> firstName = filteredNames.stream()
                .sorted()
                .findFirst();

        System.out.println("First Name after Sorting: " + (firstName.isPresent() ? firstName.get() : "No names found"));

    }
}
