package ru.rastegaev.hashtable.HashTable;

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
    public String toString() {
        if (size == 0) {
            return "Коллекция пуста";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (lists[i] != null) {
                sb.append(i).append(": ").append(lists[i].toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
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
        if (o == null) {
            return 0;
        }
        return Math.abs(o.hashCode() % lists.length);
    }

    @Override
    public boolean contains(Object o) {
        return lists[findCollectionIndex(o)].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyIteratot implements Iterator<T> {
        int currentIndex = -1;
        int currentListIndex = 0;
        int expectedModCount = modCount;
        int elementInList = 0;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("В списке больше нет элементов");
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Список изменился во врмея прохода по нему");
            }
            if (lists[currentListIndex] != null && currentListIndex < size) {
                lists[currentListIndex].get(elementInList);//todo
            } else {
                ++currentListIndex;
            }
            return null;
        }
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
        if (lists[t.hashCode()] == null) {
            lists[t.hashCode()] = new ArrayList<>();
            lists[t.hashCode()].add(t);
            ++size;
            return true;
        }
        ++size;
        return lists[t.hashCode()].add(t);
    }

    @Override
    public boolean remove(Object o) {
        return this.lists[o.hashCode()].remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object cItem : c) {
            if (!this.contains(cItem)) {
                return false;
            }
        }
        return true;
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
