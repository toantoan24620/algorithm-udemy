package linked_list.circular_double_linked_list;

public class Main {
    public static void main(String[] args) {
        CircularDoubleLinkedList circularDoubleLinkedList = new CircularDoubleLinkedList();
        circularDoubleLinkedList.createCircularDoubleLinkedList(1);

        System.out.println(circularDoubleLinkedList.head.value);
        circularDoubleLinkedList.insert(2,0);
        circularDoubleLinkedList.insert(3,0);
        circularDoubleLinkedList.insert(4,0);
        circularDoubleLinkedList.insert(0,4);
        circularDoubleLinkedList.insert(-1,5);
        circularDoubleLinkedList.insert(-2,6);

        circularDoubleLinkedList.traversal();
    }
}
