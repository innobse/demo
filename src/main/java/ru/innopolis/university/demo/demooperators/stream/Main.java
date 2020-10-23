package ru.innopolis.university.demo.demooperators.stream;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Collection<Integer> numbers = asList(9, 8, 5, 4, 6, 2, 7, 3, 1);
    Collection<Person> persons = asList(
        new Person("Василий", "Теркин"),
        new Person("Иван", "Петров"),
        new Person("Петр", "Иванов"),
        new Person("Володя", "Сидоров")
    );

//    demoFilter(numbers);
//    demoMap(numbers);
//    demoMapPerson(persons);
//    demoSort(numbers);
//    demoCount(numbers);
//    demoFirst(numbers);
    demoAnyMatch(numbers);
  }

  private static void demoAnyMatch(Collection<Integer> nums) {
    boolean isParityConsist = nums.stream()
        .anyMatch(n -> n % 2 == 0);

    System.out.println("Есть ли в коллекции хотя бы одна четная цифра: " + isParityConsist);
  }

  private static void demoFirst(Collection<Integer> nums) {
    final Optional<Integer> first = nums.stream()
        .filter(n -> n % 2 == 0)
        .findFirst();

    final Integer result = first.orElseThrow(NullPointerException::new);
    System.out.println("Первое попавшееся четное число: " + result);
  }

  private static void demoCount(Collection<Integer> nums) {
    final long count = nums.stream()
        .filter(n -> n % 2 == 0)
        .count();

    System.out.println("Количество четных цифр в коллекции: " + count);
  }

  private static void demoFilter(Collection<Integer> nums) {
    final List<Integer> parityNumbers = nums.stream()
        .filter(number -> number % 2 == 0)
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());
    System.out.println(parityNumbers);
  }

  private static void demoMap(Collection<Integer> nums) {
    nums.parallelStream()
        .map(num -> num + 3)
        .forEach(System.out::println);
  }

  private static void demoSort(Collection<Integer> nums) {
    nums.stream()
        .sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
  }

  private static void demoMapPerson(Collection<Person> nums) {
    nums.stream()
        .map(Person::getSurname)
        .forEach(System.out::println);
  }

}
