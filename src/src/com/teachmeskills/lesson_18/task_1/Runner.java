package com.teachmeskills.lesson_18.task_1;

/*Задача 1
Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
С помощью Stream'ов:
        - Удалить дубликаты
	    - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
        - Каждый элемент умножить на 2
        - Отсортировать и вывести на экран первых 4 элемента
     	- Вывести количество элементов в стриме
     	- Вывести среднее арифметическое всех чисел в стриме*/


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new  Random();

        for (int i = 0; i < 15; i++){
            numbers.add(random.nextInt(20));
        }

        System.out.println("List " + numbers);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Remove duplicates" + distinctNumbers);


        List<Integer> evenRange = distinctNumbers.stream()
                .filter(n -> n % 2 == 0 && n >= 7 && n <= 17)
                .collect(Collectors.toList());

        System.out.println("Display all even elements in the range from 7 to 17" + evenRange);


        List<Integer> doubled = distinctNumbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("Multiply each element by 2" + doubled);

        List<Integer> firstSorted = distinctNumbers.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());

        System.out.println("Sort and display the first 4 elements" + firstSorted);

        long count = distinctNumbers.stream()
                .count();
        System.out.println("Display the number of elements in the stream " + count);

        OptionalDouble average = distinctNumbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Display the arithmetic mean of all numbers in the stream" + average);

    }
}
