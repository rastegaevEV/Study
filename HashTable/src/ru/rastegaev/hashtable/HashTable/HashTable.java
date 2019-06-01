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
        for (int i = 0; i < lists.length; ++i) {
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
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int currentIndex = -1;
        int currentListIndex = 0;
        int expectedModCount = modCount;
        int hashTableElement = 0;

        @Override
        public boolean hasNext() {
            return hashTableElement != size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("В списке больше нет элементов");
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Список изменился во врмея прохода по нему");
            }
            if (lists[currentListIndex] != null && currentIndex < lists[currentListIndex].size() - 1) {
                ++currentIndex;
            } else {
                ++currentListIndex;
                while (lists[currentListIndex] == null) {
                    ++currentListIndex;
                }
                currentIndex = 0;
            }
            ++hashTableElement;
            return lists[currentListIndex].get(currentIndex);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int arrayIndex = 0;
        for (T item : this) {
            if (item != null) {
                array[arrayIndex] = item;
                ++arrayIndex;
            }
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int tIndex = findCollectionIndex(t);
        if (lists[tIndex] == null) {
            lists[tIndex] = new ArrayList<>();
        }
        ++size;
        ++modCount;
        return lists[tIndex].add(t);
    }

    @Override
    public boolean remove(Object o) {
        int removeIndex = findCollectionIndex(o);
        if (this.lists[removeIndex].remove(o)) {
            --size;
            if (lists[removeIndex].isEmpty()) {
                lists[removeIndex] = null;
            }
            ++modCount;
            return true;
        }
        return false;
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
