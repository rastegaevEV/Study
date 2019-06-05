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
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер таблицы должен быть больше 0");
        }
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
                sb.append("hash ").append(i).append(": ").append(lists[i].toString()).append(System.lineSeparator());
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
        int oIndex = findCollectionIndex(o);

        if (lists[oIndex] == null) {
            return false;
        }
        return lists[oIndex].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentListIndex = 0;
        private int expectedModCount = modCount;
        private int hashTableElement = 0;

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
            array[arrayIndex] = item;
            ++arrayIndex;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("Переданный массив не должен быть null.");
        }

        Object[] items = toArray();
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
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
        boolean isDeleted = false;
        if (lists[removeIndex] != null) {
            isDeleted = lists[removeIndex].remove(o);

            if (lists[removeIndex].isEmpty()) {
                lists[removeIndex] = null;
            }
        }
        if (isDeleted) {
            --size;
            ++modCount;
        }
        return isDeleted;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }
        if (c.isEmpty()) {
            return false;
        }
        int expectedModCount = modCount;
        for (Object cItem : c) {
            int index = findCollectionIndex(cItem);
            //noinspection SuspiciousMethodCalls
            while (lists[index] != null && lists[index].remove(cItem)) {
                ++modCount;
                --size;
                if (lists[index].isEmpty()) {
                    lists[index] = null;
                }
            }
        }
        return expectedModCount != modCount;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }

        for (Object cItem : c) {
            if (!this.contains(cItem)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }

        for (T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }

        int expectedModCount = modCount;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                int currentListSize = lists[i].size();
                if (lists[i].retainAll(c)) {
                    ++modCount;
                    size -= currentListSize - lists[i].size();
                }
                if (lists[i].isEmpty()) {
                    lists[i] = null;
                }
            }
        }
        return expectedModCount != modCount;
    }

    @Override
    public void clear() {
        for (int i = 0; i < lists.length; ++i) {
            lists[i] = null;
        }
        size = 0;
        ++modCount;
    }
}
