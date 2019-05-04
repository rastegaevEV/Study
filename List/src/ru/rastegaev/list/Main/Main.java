package ru.rastegaev.list.Main;

import ru.rastegaev.list.List.SingleLinkedList;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addToTop(1);
        list.addToTop(2);
        list.addToTop(3);
        list.addToTail(9);

        System.out.println(list.toString());

        System.out.println("Удален элемент " + list.deleteViaIndex(3));

        System.out.println(list.toString());

        System.out.println("Вставка по индексу");
        list.insertViaIndex(1, 88);
        System.out.println(list.toString());
        System.out.println("Удаление элемента по значению: " + list.delete(88));
        System.out.println(list.toString());
        System.out.println("Разворот списка");
        list.turn();
        System.out.println(list.toString());
        System.out.println("Копирование");
        SingleLinkedList<Integer> listCopy = new SingleLinkedList<>(list);
        System.out.println(listCopy.toString());
    }
}
