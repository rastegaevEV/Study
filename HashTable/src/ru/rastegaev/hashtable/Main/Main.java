package ru.rastegaev.hashtable.Main;

import ru.rastegaev.hashtable.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hash1 = new HashTable<>();
        hash1.add(5);
        hash1.add(2);
        hash1.add(2);
        hash1.add(5);
        hash1.add(8);
        hash1.add(4);
        System.out.println(hash1);
    }
}
