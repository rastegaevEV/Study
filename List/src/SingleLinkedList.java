public class SingleLinkedList<T> {
    private ListItem<T> head;
    private int count;

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

    public void setCount(int count) {
        this.count = count;
    }

}
