package ru.rastegaev.arrayList.Main;

import ru.rastegaev.arrayList.ArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        ArrayList<Integer> listDefault = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        listDefault.add(55);
        listDefault.add(66);
        listDefault.add(77);
        listDefault.add(88);
        listDefault.add(99);
        listDefault.add(100);
        System.out.println(list);
        list.addAll(listDefault);
        System.out.println(list);
    }
}
