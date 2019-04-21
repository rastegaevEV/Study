package ru.rastegaev.list;

public class SingleLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SingleLinkedList() {

    }

    public SingleLinkedList(ListItem<T> head) {
        this.head = head;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void print() {
        for (ListItem<T> item = head; item != null; item = item.getNext()) {
            System.out.println(item.getData());
        }
    }

    public int getSize() {
        return this.count;
    }

    public T getFirstItemData() {
        return this.head.getData();
    }

    public T getDataByIndex(int index) {
        if (index < 1 || index > this.count) {
            throw new IllegalArgumentException("Такого индекса в списке нет");
        }
        int currentIndex = 1;
        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (currentIndex == index) {
                return currentItem.getData();
            }
            ++currentIndex;
        }
        return null;
    }

    public T setDataByIndex(int index, T data) {
        if (index < 1 || index > this.count) {
            throw new IllegalArgumentException("Такого индекса в списке нет");
        }
        int currentIndex = 1;
        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (currentIndex == index) {
                T oldData = currentItem.getData();
                currentItem.setData(data);
                return oldData;
            }
            ++currentIndex;
        }
        return null;
    }

    public T deleteElementByIndex(int index) {
        if (index < 1 || index > this.count) {
            throw new IllegalArgumentException("Такого индекса в списке нет");
        }
        if (index == 1) {
            --this.count;
            return deleteFirst();
        }
        int currentIndex = 2;
        for (ListItem<T> currentItem = head.getNext(), previousItem = head; currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (currentIndex == index) {
                previousItem.setNext(currentItem.getNext());
                --this.count;
                return currentItem.getData();
            }
            ++currentIndex;
        }
        return null;
    }

    public void addToTop(T data) {
        this.head = new ListItem<>(data, head);
        ++this.count;
    }

    public void insertByIndex(int index, T data) {
        if (index < 1 || index > this.count) {
            throw new IllegalArgumentException("Такого индекса в списке нет");
        }
        if (index == 1) {
            addToTop(data);
        }
        ListItem<T> item = new ListItem<>(data);
        int currentIndex = 2;
        for (ListItem<T> currentItem = this.head.getNext(), previousItem = this.head; currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (currentIndex == index) {
                previousItem.setNext(item);
                item.setNext(currentItem);
                ++this.count;
                return;
            }
            ++currentIndex;
        }
    }

    public boolean ifDeleted(T data) {
        if (this.head.getData().equals(data)) {
            deleteFirst();
            return true;
        }
        for (ListItem<T> currentItem = this.head.getNext(), previousItem = head; currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (currentItem.getData().equals(data)) {
                previousItem.setNext(currentItem.getNext());
                return true;
            }
        }
        return false;
    }

    public T deleteFirst() {
        T deleteData = this.head.getData();
        this.head = this.head.getNext();
        --this.count;
        return deleteData;
    }

    public void addToTheEnd(T data) {
        ListItem<T> item = new ListItem<>(data);
        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (currentItem.getNext() == null) {
                currentItem.setNext(item);
                ++this.count;
                return;
            }
        }
    }

    public void turn() {
        ListItem<T> previousItem = null;

        for (ListItem<T> currentItem = this.head, nextItem = currentItem.getNext(); nextItem != null; currentItem = nextItem, nextItem = nextItem.getNext()) {
            currentItem.setNext(previousItem);
            if (nextItem.getNext() == null) {
                this.head = nextItem;
                nextItem.setNext(currentItem);
                return;
            }
            previousItem = currentItem;
        }
    }

    public SingleLinkedList(SingleLinkedList<T> list) {
        this.head = new ListItem<>(list.head.getData());
        this.count = list.count;
        for (ListItem<T> item = list.head.getNext(); item != null; item = item.getNext()) {
            addToTheEnd(item.getData());
        }
    }
}
