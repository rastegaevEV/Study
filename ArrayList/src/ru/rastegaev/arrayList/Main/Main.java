package ru.rastegaev.arrayList.Main;

import ru.rastegaev.arrayList.MyArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        ArrayList<Integer> listDefault = new ArrayList<>();
        MyArrayList<Integer> someList = new MyArrayList<>();
        MyArrayList<Integer> emptyList = new MyArrayList<>();
        someList.add(1);
        someList.add(5);
        someList.add(155);
        someList.add(null);
        someList.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(155);
        listDefault.add(55);
        listDefault.add(111);
        listDefault.add(4);
        System.out.println(list);
        System.out.println(someList);
        list.removeAll(someList);
        System.out.println(list);
        System.out.println(list.containsAll(emptyList));
    }
}
