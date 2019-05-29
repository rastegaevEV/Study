package ru.rastegaev.arrayList.MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount = 0;

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

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекса в списке нет");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < size; ++i) {
            if (i + 1 == size) {
                stringBuilder.append(this.items[i]);
            } else {
                stringBuilder.append(this.items[i]).append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int expectedModCount = modCount;

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
        ++modCount;
        return true;
    }

    private void increaseCapacity() {
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    public void ensureCapacity(int minCapacity) {
        if (this.items.length < minCapacity) {
            this.items = Arrays.copyOf(this.items, minCapacity);
        }
    }

    public void trimToSize() {
        if (this.items.length < this.size) {
            this.items = Arrays.copyOf(this.items, size);
            ++modCount;
        }
    }

    @Override
    public boolean remove(Object o) {
        int removeIndex = indexOf(o);

        if (removeIndex != -1) {
            remove(removeIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не может равняться null");
        }
        if (c.isEmpty()) {
            return false;
        }
        addAll(this.size, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не может равняться null");
        }
        if (c.isEmpty()) {
            return false;
        }
        checkIndex(index);
        ensureCapacity(this.size + c.size());
        System.arraycopy(this.items, index, this.items, index + c.size(), this.size - index);
        int i = index;
        for (T cItem : c) {
            this.items[i] = cItem;
            ++i;
        }
        this.size += c.size();
        ++modCount;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; ++i) {
            this.items[i] = null;
        }
        ++modCount;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Индекса в списке нет");
        }
        return this.items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Индекса в списке нет");
        }
        T temp = this.items[index];
        this.items[index] = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if (this.items.length == size) {
            increaseCapacity();
        }
        int replaceCount = size - index;
        System.arraycopy(this.items, index, this.items, index + 1, replaceCount);
        this.items[index] = element;
        ++size;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Индекса в списке нет");
        }
        T removeItem = this.items[index];

        System.arraycopy(this.items, index + 1, this.items, index, this.size - (index + 1));

        ++modCount;
        --size;
        return removeItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(this.items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.size - 1; i >= 0; --i) {
            if (Objects.equals(this.items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }
        int removeMod = 0;
        for (int i = 0; i < size; ++i) {
            if (!c.contains(this.items[i])) {
                remove(i);
                --i;
                ++removeMod;
            }
        }
        return removeMod > 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");
        }
        if (c.isEmpty()) {
            return false;
        }
        int removeMod = 0;

        for (Object cItem : c) {
            remove(cItem);
            ++removeMod;
        }
        return removeMod > 0;
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

    @SuppressWarnings("TypeParameterHidesVisibleType")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("Переданный массив не может равняться null");
        }
        if (a.length < this.size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(this.items, size, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.items, 0, a, 0, this.size);
        if (a.length > this.size) {
            a[size] = null;
        }
        return a;
    }
}
