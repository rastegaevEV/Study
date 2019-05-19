package ru.rastegaev.arrayList.ArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private static int modCount = 0;

    public MyArrayList() {
        //noinspection unchecked
        this.items = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0");
        }
        //noinspection unchecked
        this.items = (T[]) new Object[capacity];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size &&
                Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (T item : this.items) {
            stringBuilder.append(item).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.items.length <= 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator() ;
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modCount = MyArrayList.modCount;

        public int getCurrentIndex () {
            return currentIndex;
        }

        @Override
        public boolean hasNext() {
            return currentIndex + 1 != size;
        }

        @Override
        public T next() {
            if (currentIndex + 1 == size) {
                throw new NoSuchElementException();
            }
            if (modCount != MyArrayList.modCount) {
                throw new ConcurrentModificationException();
            }
            while (hasNext()) {
                ++currentIndex;
            }
            return items[currentIndex];
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.items, size);
    }

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            increaseCapacity();
        }
        this.items[size] = item;
        ++size;
        return true;
    }

    private void increaseCapacity() {
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Значение не может равняться null");
        }
        int removeIndex = indexOf(o);

        if (indexOf(o) != -1) {
            remove(removeIndex);
            ++modCount;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не может равняться null");
        }
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Iterator<T> iteratorNew = (Iterator<T>) c.iterator();
        Iterator<T> iteratorCurrent = (Iterator<T>) c.iterator();
        //todo
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        int temp = index;
        T removeItem = this.items[index];
        while (temp < size) {
            this.items[temp] = this.items[temp + 1];
            ++temp;
        }
        ++modCount;
        return removeItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.items.length; ++i) {
            if (this.items[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
