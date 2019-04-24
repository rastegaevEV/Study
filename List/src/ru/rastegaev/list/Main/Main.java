package ru.rastegaev.list.Main;

import ru.rastegaev.list.List.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addToTop(1);
        list.addToTop(2);
        list.addToTop(3);
        list.addToTail(9);

        list.print();

        System.out.println("Удален элемент " + list.deleteViaIndex(3));

        list.print();

        System.out.println("Вставка по индексу");
        list.insertViaIndex(1, 88);
        list.print();
        System.out.println("Удаление элемента по значению: " + list.deleted(88));
        list.print();
        System.out.println("Разворот списка");
        list.turn();
        list.print();
        System.out.println("Копирование");
        SingleLinkedList<Integer> listCopy = new SingleLinkedList<>(list);
        listCopy.print();
        System.out.println(listCopy.setViaIndex(0, 345));












        /*ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        list.add("345");
        list.remove(0);
        System.out.println(list);
        list.ensureCapacity(20);*/
    }
}
