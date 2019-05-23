package ru.rastegaev.arrayList.Main;

import ru.rastegaev.arrayList.MyArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        ArrayList<Integer> listDefault = new ArrayList<>();
        MyArrayList<Integer> someList = new MyArrayList<>();
        Integer[] array = new Integer[10];
        someList.add(1);
        someList.add(5);
        someList.add(155);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(155);
        listDefault.add(55);
        listDefault.add(66);
        listDefault.add(77);
        listDefault.add(88);
        listDefault.add(99);
        listDefault.add(100);
        listDefault.add(111);
        listDefault.add(4);
        System.out.println(list);
        System.out.println(list.lastIndexOf(155));
        System.out.println(someList);
        System.out.println(list.containsAll(someList));
        list.removeAll(someList);
        System.out.println(list);
        list.toArray(array);
        System.out.println(Arrays.toString(array));

    }
}
