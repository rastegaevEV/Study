public class SingleLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SingleLinkedList() {

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
        int currentIndex = 1;
        for (ListItem<T> currentItem = head, previousItem = null; currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (currentIndex == index) {
                previousItem.setNext(currentItem.getNext());
                return currentItem.getData();//todo доделать

            }
            ++currentIndex;
        }
        return null;
    }

    public int getSize() {
        return this.count;
    }

    public void addToTop(T data) {
        this.head = new ListItem<>(data, head);
        ++this.count;
    }

    public void addToTheEnd(T data) {
        ListItem<T> item = new ListItem<>(data, null);
        for (ListItem<T> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (currentItem.getNext() == null) {
                currentItem.setNext(item);
                return;
            }
        }

    }

}
