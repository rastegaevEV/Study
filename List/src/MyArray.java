import java.util.Arrays;

public class MyArray {
    private Object[] items = new Object[10];
    private int length;

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public Object getItem(int index){
        return items[index];
    }

    public void setItem(int index, Object object) {
        this.items[index] = object;
    }

    public void add (Object object) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = object;
        ++length;
    }

    public void increaseCapacity() {
        this.items = Arrays.copyOf(items, items.length * 2);
    }

    public void remove(int index) {
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        -- index;
    }
}
