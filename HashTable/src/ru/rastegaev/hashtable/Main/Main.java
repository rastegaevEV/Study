package ru.rastegaev.hashtable.Main;

import ru.rastegaev.hashtable.HashTable.HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hash1 = new HashTable<>();
        HashTable<Integer> hash2 = new HashTable<>();
        hash1.add(5);
        hash1.add(2);
        hash1.add(2);
        hash1.add(5);
        hash1.add(8);
        hash1.add(4);

        hash2.add(155);
        hash2.add(234);
        hash2.add(569);
        System.out.println(hash1);
        hash1.remove(4);
        System.out.println(hash1);
        System.out.println(Arrays.toString(hash1.toArray()));
        System.out.println(hash1.size());
        System.out.println(hash1.containsAll(hash2));
        hash1.addAll(hash2);
        System.out.println(hash1);
        hash1.retainAll(hash2);
        System.out.println(hash1);
        hash1.clear();
        System.out.println(hash1);
    }
}
