public class Main {
    public static void main(String[] args) {
        ListItem<String> data1 = new ListItem<>("fff");
        ListItem<String> data2 = new ListItem<>("ddd", data1);
        ListItem<String> data3 = new ListItem<>("ccc", data2);
        SingleLinkedList<String> list = new SingleLinkedList<>(data3);

        System.out.println(list);





        /*ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        list.add("345");
        list.remove(0);
        System.out.println(list);
        list.ensureCapacity(20);*/
    }
}
