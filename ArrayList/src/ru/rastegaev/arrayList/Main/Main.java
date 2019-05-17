package ru.rastegaev.arrayList.Main;

import ru.rastegaev.arrayList.ArrayList.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(6);
        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        list.add("rty");
        list.add("fgh");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.remove("qwe");
        System.out.println(list);
    }
}
