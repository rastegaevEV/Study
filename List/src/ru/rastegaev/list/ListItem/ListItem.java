package ru.rastegaev.list.ListItem;

import java.util.Objects;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public ListItem(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem<?> listItem = (ListItem<?>) o;
        return data == listItem.data &&
                next == listItem.next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}
