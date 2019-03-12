package ru.rastegaev.list.main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        list.add("345");
        list.remove(0);
        System.out.println(list);
        list.ensureCapacity(20);
    }
}
