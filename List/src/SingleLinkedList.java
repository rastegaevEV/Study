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

    public void addToTop (T data) {
        this.head = new ListItem<>(data, head);
        ++this.count;
    }

    public void addToTheEnd (T data) {
        ListItem<T> item = new ListItem<>(data, null);
        for (ListItem<T> item1 = head; item1 != null; item1 = item1.getNext()) {
            if (item1.getNext() == null) {
                item1.setNext(item);
                return;
            }
        }

    }

}
