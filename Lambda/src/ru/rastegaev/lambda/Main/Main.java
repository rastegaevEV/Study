package ru.rastegaev.lambda.Main;

import ru.rastegaev.lambda.Person.Person;

import java.util.ArrayList;

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
    }
}
