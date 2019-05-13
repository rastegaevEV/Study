package ru.rastegaev.list.List;

import ru.rastegaev.list.ListItem.ListItem;

import java.util.Objects;

public class SingleLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SingleLinkedList() {
    }

    public SingleLinkedList(SingleLinkedList<T> list) {
        if (list.count == 0) {
            this.head = null;
            return;
        }
        this.count = list.count;
        ListItem<T> item = list.head;
        ListItem<T> nextItem = item.getNext();

        ListItem<T> itemCopy = new ListItem<>(list.head.getData(), null);
        this.head = itemCopy;

        while (nextItem != null) {
            ListItem<T> nextItemCopy = new ListItem<>(nextItem.getData(), null);
            itemCopy.setNext(nextItemCopy);
            itemCopy = nextItemCopy;
            nextItem = nextItem.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (ListItem<T> item = this.head; item != null; item = item.getNext()) {
            stringBuilder.append(item.getData()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int getSize() {
        return this.count;
    }

    public T getFirstItemData() {
        if (this.head == null) {
            throw new NullPointerException("Список пуст");
        }
        return this.head.getData();
    }

    private ListItem<T> getItemByIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Такого индекса в списке нет");
        }
        int currentIndex = 0;
        for (ListItem<T> indexItem = this.head; indexItem != null; indexItem = indexItem.getNext()) {
            if (currentIndex == index) {
                return indexItem;
            }
            ++currentIndex;
        }
        return head;
    }

    public T getDataViaIndex(int index) {
        return getItemByIndex(index).getData();
    }

    public T setViaIndex(int index, T data) {
        ListItem<T> indexItem = getItemByIndex(index);
        T oldData = indexItem.getData();
        indexItem.setData(data);
        return oldData;
    }

    public T deleteViaIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Такого индекса в списке нет");
        }
        if (index == 0) {
            return deleteFirst();
        }
        ListItem<T> previousItem = getItemByIndex(index - 1);
        ListItem<T> indexItem = previousItem.getNext();
        previousItem.setNext(indexItem.getNext());
        --this.count;
        return indexItem.getData();
    }

    public void addToTop(T data) {
        this.head = new ListItem<>(data, head);
        ++this.count;
    }

    public void insertViaIndex(int index, T data) {
        if (index < 0 || index > this.count) {
            throw new IndexOutOfBoundsException("Такого индекса в списке нет");
        }
        if (index == this.count) {
            addToTail(data);
            return;
        }
        if (index == 0) {
            addToTop(data);
            return;
        }
        ListItem<T> newItem = new ListItem<>(data);
        ListItem<T> previousItem = getItemByIndex(index - 1);
        ListItem<T> indexItem = previousItem.getNext();
        previousItem.setNext(newItem);
        newItem.setNext(indexItem);
        ++this.count;
    }

    public boolean delete(T data) {
        if (this.head == null) {
            return false;
        }

        if (Objects.equals(this.head.getData(), data)) {
            deleteFirst();
            return true;
        }

        for (ListItem<T> currentItem = this.head.getNext(), previousItem = head;
             currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (Objects.equals(currentItem.getData(), data)) {
                previousItem.setNext(currentItem.getNext());
                --this.count;
                return true;
            }
        }
        return false;
    }

    public T deleteFirst() {
        if (this.head == null) {
            throw new NullPointerException("Список пуст");
        }
        T deleteData = this.head.getData();
        this.head = this.head.getNext();
        --this.count;
        return deleteData;
    }

    public void addToTail(T data) {
        if (this.head == null) {
            addToTop(data);
            return;
        }
        ListItem<T> item = new ListItem<>(data);
        getItemByIndex(this.count - 1).setNext(item);
        ++this.count;
    }

    public void turn() {
        if (this.head == null) {
            return;
        }
        ListItem<T> previousItem = null;
        for (ListItem<T> currentItem = this.head, nextItem = currentItem.getNext();
             nextItem != null; currentItem = nextItem, nextItem = nextItem.getNext()) {
            currentItem.setNext(previousItem);
            if (nextItem.getNext() == null) {
                this.head = nextItem;
                nextItem.setNext(currentItem);
                return;
            }
            previousItem = currentItem;
        }
    }
}
