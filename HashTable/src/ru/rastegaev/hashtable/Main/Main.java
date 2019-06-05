package ru.rastegaev.hashtable.Main;

import ru.rastegaev.hashtable.HashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hash1 = new HashTable<>();
        HashTable<Integer> hash2 = new HashTable<>();

        hash1.add(5);
        hash1.add(2);
        hash1.add(2);
        hash1.add(5);
        hash1.add(8);
        hash1.add(569);
        hash1.add(135);

        hash2.add(2);
        hash2.add(5);
        hash2.add(569);

        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(hash1.remove(2));
        System.out.println(hash1);
        System.out.println(hash1.size());
        for (Integer item : hash1) {
            System.out.println(item);
        }
        System.out.println(hash1.removeAll(hash2));
        System.out.println(hash1);

        for (Integer item : hash1) {
            System.out.println(item);
        }
    }
}
