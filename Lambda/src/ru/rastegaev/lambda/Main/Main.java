package ru.rastegaev.lambda.Main;

import ru.rastegaev.lambda.Person.Person;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Евгений", 29));
        people.add(new Person("Иван", 30));
        people.add(new Person("Антон", 29));
        people.add(new Person("Евгений", 30));
        people.add(new Person("Наталья", 28));
        people.add(new Person("Петр", 17));
        people.add(new Person("Павел", 16));
        people.add(new Person("Елена", 15));
        people.add(new Person("Иван", 10));

        System.out.println("Имена: " + people.stream().map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ")));
        System.out.println();

        System.out.println("Средний возраст людей до 18 лет: " + people.stream()
                .filter(x -> x.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average().orElse(0));
        System.out.println();

        Map<String, Double> peopleByAverageAge = people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        peopleByAverageAge.forEach((name, age) -> System.out.println("Имя: " + name + ", средний возраст: " + age));
        System.out.println();

        System.out.println(people.stream().filter(x -> x.getAge() > 20 && x.getAge() < 45)
                .sorted((x1, x2) -> x2.getAge() - x1.getAge())
                .map(Person::getName).collect(Collectors.joining(", ")));
    }
}
