public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addToTop(1);
        list.addToTop(2);
        list.addToTop(3);
        list.addToTheEnd(9);

        list.print();

        System.out.println(list.getDataByIndex(1));
        System.out.println();
        System.out.println(list.setDataByIndex(1, 99));
        System.out.println();

        list.print();
        System.out.println("Удаление по индексу 3");
        list.deleteElementByIndex(3);
        list.print();








        /*ArrayList<String> list = new ArrayList<String>();
        list.add("123");
        list.add("345");
        list.remove(0);
        System.out.println(list);
        list.ensureCapacity(20);*/
    }
}
