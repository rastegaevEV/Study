package ru.rastegaev.list.Main;

import ru.rastegaev.list.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addToTop(1);
        list.addToTop(2);
        list.addToTop(3);
        list.addToTheEnd(9);

        list.print();

        System.out.println("Удален элемент " + list.deleteElementByIndex(3));

        list.print();

        System.out.println("Вставка по индексу");
        list.insertByIndex(1, 88);
        list.print();
        System.out.println("Удаление элемента по значению: " + list.ifDeleted(88));
        list.print();
        System.out.println("Разворот списка");
        list.turn();
        list.print();
        System.out.println("Копирование");
        SingleLinkedList<Integer> listCopy = new SingleLinkedList<>(list);
        listCopy.print();











        /*ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        list.add("345");
        list.remove(0);
        System.out.println(list);
        list.ensureCapacity(20);*/
    }
}
