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
        return lists[findCollectionIndex(o)].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyIteratot implements Iterator<T> {
        int currentIndex = -1;
        int expectedModCount = modCount;

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
            ++currentIndex;
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
