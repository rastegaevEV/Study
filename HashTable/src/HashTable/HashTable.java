package HashTable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] lists;
    private int size;
    private int modCount = 0;

    public HashTable() {
        //noinspection unchecked
        this.lists = (ArrayList<T>[]) new ArrayList[10];
    }

    public HashTable(int capacity) {
        //noinspection unchecked
        this.lists = (ArrayList<T>[]) new ArrayList[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private int findCollectionIndex(Object o) {
        return Math.abs(o.hashCode() % lists.length);
    }

    @Override
    public boolean contains(Object o) {
        return lists[o.hashCode()].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
