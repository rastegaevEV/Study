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

    private void indexCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Индекса в списке нет");
        }
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
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modCount = MyArrayList.modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (currentIndex + 1 == size) {
                throw new NoSuchElementException("В списке больше нет элементов");
            }
            if (modCount != MyArrayList.modCount) {
                throw new ConcurrentModificationException("Список изменился во врмея прохода по нему");
            }
            if (hasNext()) {
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
        ++modCount;
        return true;
    }

    private void increaseCapacity() {
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    private void increaseCapacity(int capacity) {
        this.items = Arrays.copyOf(this.items, capacity);
    }

    private void ensureCapacity(int minCapacity) {
        if (this.items.length < minCapacity) {
            this.items = Arrays.copyOf(this.items, minCapacity);
        }
    }

    private void trimToSize() {
        this.items = Arrays.copyOf(this.items, size);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Значение не может равняться null");
        }
        int removeIndex = indexOf(o);

        if (indexOf(o) != -1) {
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
        indexCheck(index);
        Object[] cArray = c.toArray();

        if (c.size() == 0) {
            return false;
        }
        if (this.items.length < size + c.size()) {
            increaseCapacity(size + c.size());
        }

        Object[] items = this.items;
        int moveItems = size - index;

        if (moveItems > 0) {
            System.arraycopy(items, index, items, size + c.size() - moveItems, moveItems);
        }
        System.arraycopy(cArray, 0, items, index, cArray.length);
        this.size += c.size();
        ++modCount;
        return false;
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
        indexCheck(index);
        return this.items[index];
    }

    @Override
    public T set(int index, T element) {
        indexCheck(index);
        T temp = this.items[index];
        this.items[index] = element;
        ++modCount;
        return temp;

    }

    @Override
    public void add(int index, T element) {
        indexCheck(index);
        if (this.items.length == size) {
            increaseCapacity();
        }
        int replaceCount = size - index;
        System.arraycopy(this.items, size - replaceCount, this.items, index + 1, replaceCount);
        set(index, element);
        ++size;
    }

    @Override
    public T remove(int index) {
        indexCheck(index);
        int temp = index;
        T removeItem = this.items[index];
        while (temp < size) {
            this.items[temp] = this.items[temp + 1];
            ++temp;
        }
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
        int lastIndex = -1;
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(this.items[i], o)) {
                lastIndex = i;
            }
        }
        return lastIndex;
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
        if (c.isEmpty()) {
            return false;
        }
        int removeMod = 0;
        for (int i = 0; i < size; ++i) {
            if (!c.contains(this.items[i])) {
                remove(i);
                --i;
                ++removeMod;
            }
        }
        trimToSize();
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
        for (int i = 0; i < size; ++i) {
            for (Object cItem : c) {
                if (Objects.equals(this.items[i], cItem)) {
                    remove(i);
                    --i;
                    ++removeMod;
                    break;
                }
            }
        }
        trimToSize();
        return removeMod > 0;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            throw new NullPointerException("Коллекция не должна быть null");// todo
        }
        if (c.isEmpty()) {
            return false;
        }
        int coincidence = 0;
        for (Object cItem : c) {
            if (this.contains(cItem)) {
                ++coincidence;
            }
        }
        return coincidence == c.size();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a == null) {
            throw new NullPointerException("Переданный массив не может равняться null");
        }
        if (a.length < this.size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(this.items, size, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.items, 0, a, 0, this.size);
        if (a.length > this.size) {
            a[size] = null;
        }
        return a;
    }
}
